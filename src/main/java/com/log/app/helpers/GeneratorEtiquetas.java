package com.log.app.helpers;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.tools.ant.util.FileUtils;
import org.aspectj.apache.bcel.util.ClassPath;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.log.app.entidades.Pedido;
import com.log.app.entidades.PedidoProducto;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;
import com.log.app.entidades.TipoProducto;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;

/**
 * Metodos de ayuda para el servicio de etiquetas.
 * 
 * @author Clawtech
 * @version 1.0
 * @since 1.0
 */

@Component
public class GeneratorEtiquetas {
    public GeneratorEtiquetas() {

    }

    private String URL = "https://storage.googleapis.com/clawtechlogo/logo.png";

    /**
     * Crea un PDF con el remito de recepcion.
     * 
     * @param recepcion
     * @return PDDocument
     * @throws IOException
     * @throws URISyntaxException
     */
    public PDDocument createRemitoRecepcion(final Recepcion recepcion) throws IOException, URISyntaxException {
        URL url = new URL(URL);
        File file = new File(url.getFile());

        final java.awt.image.BufferedImage barcodeImage = generateEAN13BarcodeImage(
                recepcion.getIdRecepcion().toString());
        final PDDocument document = new PDDocument();
        // PDImageXObject pdImage = PDImageXObject.createFromFileByContent(file,
        // document);
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, ImageIO.read(url));

        try {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            final PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA, 10);

            createTableDetalleRecepcion(document, page, contentStream, recepcion);

            contentStream.beginText();

            addRecepcionData(document, page, recepcion, contentStream);
            contentStream.endText();

            // File file = new ClassPathResource("logo.png").getFile();

            addImageToPdf(document,
                    100, 150, 100, 50, true,
                    barcodeImage,
                    contentStream);

            contentStream.drawImage(pdImage, 450, 700, 100, 100);

            contentStream.close();
            return document;
        } catch (final Exception e) {
            return document;
        }

    }

    /**
     * @param document
     * @param page
     * @param recepcion
     * @throws IOException
     */
    public void addRecepcionData(final PDDocument document, final PDPage page, final Recepcion recepcion,
            PDPageContentStream cs)
            throws IOException {
        final double costoTotal = recepcion.getProductos().stream().mapToDouble(x -> x.getProducto().getPrecio()).sum();

        cs.newLineAtOffset(50, 800);
        cs.setFont(PDType1Font.HELVETICA, 20);

        // cs.newLineAtOffset(600, 200);

        cs.showText("Remito de Recepcion");

        cs.setFont(PDType1Font.HELVETICA, 10);

        addText(document, page, 0, 20, 150, 30, false, "CLAWTECH", cs);
        addText(document, page, 0, 20, 150, 30, false, "UTEC - FRAY BENTOS", cs);
        addText(document, page, 0, 20, 150, 30, false, "URUGUAY", cs);

        addText(document, page, 0,
                20, 200, 30, false, "Proveedor:" +
                        recepcion.getProvedor().getNombreProv(),
                cs);
        addText(document, page, 0,
                20, 200, 30, false, "Recepcion Nª: " +
                        recepcion.getIdRecepcion() + " - " + "Fecha:" + recepcion.getFechaRecepcion().getDay() + "/"
                        + recepcion.getFechaRecepcion().getMonth() + "/" +
                        recepcion.getFechaRecepcion().getYear(),
                cs);

        addText(document, page, -300,
                500, 250, 30, false,
                "Cantidad Producto :"
                        + recepcion.getProductos().stream().mapToDouble(mapper -> mapper.getCantidad()).sum(),
                cs);
        addText(document, page, 0, 20, 250, 30, false, "Costo Total: $" +
                costoTotal, cs);

        addText(document, page, 0, 30, 250, 30, false, "Firma: ____________", cs);

    }

    /**
     * Crea los headers de la tabla con los detalles del remito de recepcion.
     * 
     * @param table
     * @return Row<PDPage>
     */
    public Row<PDPage> createHeaderTableRecepcion(final BaseTable table) {
        final Row<PDPage> headerRow = table.createRow(15f);
        final Cell<PDPage> siCell = headerRow.createCell(5, "ID");
        siCell.setFont(PDType1Font.HELVETICA_BOLD);

        final Cell<PDPage> descriptionCell = headerRow.createCell(25, "Descripcion");
        descriptionCell.setFont(PDType1Font.HELVETICA_BOLD);

        final Cell<PDPage> qtyCell = headerRow.createCell(15, "Cantidad");
        qtyCell.setFont(PDType1Font.HELVETICA_BOLD);

        final Cell<PDPage> rateCell = headerRow.createCell(15, "Precio");
        rateCell.setFont(PDType1Font.HELVETICA_BOLD);

        final Cell<PDPage> amtCell = headerRow.createCell(15, "Codigo");
        amtCell.setFont(PDType1Font.HELVETICA_BOLD);

        // cell.setFillColor(Color.BLACK);
        table.addHeaderRow(headerRow);
        return headerRow;
    }

    /**
     * Crea una tabla con los detalles del remito de recepcion.
     * 
     * @param mainDocument
     * @param myPage
     * @param contentStream
     * @param recepcion
     * @throws IOException
     */
    public void createTableDetalleRecepcion(final PDDocument mainDocument, final PDPage myPage,
            final PDPageContentStream contentStream,
            final Recepcion recepcion) throws IOException {

        final float margin = 60;
        final float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);

        final float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
        final boolean drawContent = true;
        final float bottomMargin = 35;
        final BaseTable table = new BaseTable(650, yStartNewPage, bottomMargin, tableWidth, margin, mainDocument,
                myPage,
                true, drawContent);

        final Row<PDPage> headerRow = createHeaderTableRecepcion(table);
        table.addHeaderRow(headerRow);

        final List<RecepcionProducto> d = recepcion.getProductos();
        for (int i = 0; i < d.size(); i++) {
            final Row<PDPage> row = table.createRow(10f);
            row.createCell(5, Integer.toString(i + 1));
            row.createCell(25, d.get(i).getProducto().getNombre());
            row.createCell(15, Double.toString(d.get(i).getCantidad()));
            row.createCell(15, Double.toString(d.get(i).getProducto().getPrecio()));
            row.createCell(15, d.get(i).getProducto().getCodigoDeBarras());
        }

        table.draw();

    }

    /**
     * Crea el remito del pedido
     * 
     * @param pedido
     * @return PDDocument
     * @throws IOException
     */
    public PDDocument createRemitoPedido(final Pedido pedido) throws IOException {
        URL url = new URL(URL);
        File file = new File(url.getFile());
        final java.awt.image.BufferedImage barcodeImage = generateEAN13BarcodeImage(pedido.getIdPedido().toString());

        final PDDocument document = new PDDocument();
        // PDDocument document = new PDDocument();
        final PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        final PDPageContentStream contentStream = new PDPageContentStream(document, page);
        // PDImageXObject pdImage = PDImageXObject.createFromFileByContent(file,
        // document);
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, ImageIO.read(url));

        contentStream.setFont(PDType1Font.HELVETICA, 10);
        // contentStream.addLine(0, 450, 400, 450);
        createTableDetallePedido(document, page, contentStream, pedido);
        contentStream.beginText();

        addPedidoData(document, page, pedido, contentStream);
        contentStream.endText();
        // File file = new ClassPathResource("logo.png").getFile();

        addImageToPdf(document,
                100, 150, 100, 50, true,
                barcodeImage,
                contentStream);
        contentStream.drawImage(pdImage, 450, 700, 100, 100);

        contentStream.close();

        return document;

    }

    /**
     * Agrega los datos del pedido al documento.
     * 
     * @param document
     * @param page
     * @param pedido
     * @throws IOException
     */
    public void addPedidoData(final PDDocument document, final PDPage page, final Pedido pedido, PDPageContentStream cs)
            throws IOException {
        final double costoTotal = pedido.getProductos().stream().mapToDouble(x -> x.getProducto().getPrecioDeVenta()).sum();
        // Add Company Name and details
        cs.newLineAtOffset(50, 800);
        cs.setFont(PDType1Font.HELVETICA, 20);

        // cs.newLineAtOffset(600, 200);

        cs.showText("Remito de Pedido");

        cs.setFont(PDType1Font.HELVETICA, 10);

        addText(document, page, 0, 20, 150, 30, false, "CLAWTECH", cs);
        addText(document, page, 0, 20, 150, 30, false, "UTEC - FRAY BENTOS", cs);
        addText(document, page, 0, 20, 150, 30, false, "URUGUAY", cs);

        addText(document, page, 0, 20, 200, 30, false, "Cliente:" + pedido.getCliente().getRazonSocial(), cs);
        addText(document, page, 0, 20, 200, 30, false, "Pedido Nª: " + pedido.getIdPedido() +
                " - " + "Fecha:" + pedido.getFechaPedido().getDay() + "/"
                + pedido.getFechaPedido().getMonth() + "/" + pedido.getFechaPedido().getYear(), cs);

        addText(document, page, -300,
                500, 250, 30, false,
                "Cantidad Producto :"
                        + pedido.getProductos().stream().mapToDouble(mapper -> mapper.getCantidad()).sum(),
                cs);
        addText(document, page, 0, 20, 250, 30, false, "Costo Total: $" + costoTotal, cs);

        addText(document, page, 0, 30, 250, 30, false, "Firma: ____________", cs);

    }

    /**
     * Crea la tabla de productos de un pedido
     * 
     * @param mainDocument
     * @param myPage
     * @param contentStream
     * @param pedido
     * @throws IOException
     */
    private void createTableDetallePedido(final PDDocument mainDocument, final PDPage myPage,
            final PDPageContentStream contentStream,
            final Pedido pedido) throws IOException {

        final float margin = 50;
        final float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);

        final float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
        final boolean drawContent = true;
        final float bottomMargin = 35;

        final BaseTable table = new BaseTable(650, yStartNewPage, bottomMargin, tableWidth, margin, mainDocument,
                myPage,
                true, drawContent);

        final Row<PDPage> headerRow = createHeaderTableRecepcion(table);
        table.addHeaderRow(headerRow);

        final List<PedidoProducto> d = pedido.getProductos();
        for (int i = 0; i < d.size(); i++) {
            final Row<PDPage> row = table.createRow(10f);
            row.createCell(5, Integer.toString(i + 1));
            row.createCell(25, d.get(i).getProducto().getNombre());
            row.createCell(15, Double.toString(d.get(i).getCantidad()));
            row.createCell(15, Double.toString(d.get(i).getProducto().getPrecioDeVenta()));
            row.createCell(15, d.get(i).getProducto().getCodigoDeBarras());
        }

        table.draw();

    }

    /**
     * Crea las etiquetas de los productos de una recepcion
     * 
     * @param recepcion
     * @return PDDocument
     * @throws IOException
     */
    public PDDocument createEtiquetasProductoRecepcion(final Recepcion recepcion) throws IOException {

        final PDDocument document = new PDDocument();
        try {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            final PDPageContentStream contentStream = new PDPageContentStream(document, page);
            final List<RecepcionProducto> productos = recepcion.getProductos();
            contentStream.setNonStrokingColor(Color.WHITE);
            contentStream.setStrokingColor(Color.BLACK);
            contentStream.setLineWidth(1);
            int x = 50;
            int y = 700;

            final int width = 100;
            final int height = 100;
            // for (final RecepcionProducto recepcionProducto : productos) {
            // addText(document, page, x, y, 200, 50, false,
            // "Codigos de barra producto: " + recepcionProducto.getProducto().getNombre());
            // y -= height;
            // for (int i = 0; i < recepcionProducto.getCantidad(); i++) {

            // final java.awt.image.BufferedImage image =
            // generateEAN13BarcodeImage(String.valueOf(
            // recepcionProducto.getProducto().getCodigoDeBarras()));
            // addImageToPdf(document, x, y, width, height, true,
            // image, contentStream);

            // contentStream.addRect(x, y, width, height);

            // x += width;
            // if (x > 500) {
            // x = 50;
            // y -= height;
            // }
            // }

            // }
            contentStream.stroke();

            contentStream.close();

            return document;
        } catch (final Exception e) {
            return document;
        }

    }

    /**
     * Crea las etiquetas de los productos de una lista de productos
     * 
     * @param listaProductos
     * @return PDDocument
     * @throws IOException
     */
    public PDDocument createEtiquetasListadoProductos(final List<TipoProducto> listaProductos) throws IOException {

        final PDDocument document = new PDDocument();
        try {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            final PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();

            contentStream.newLineAtOffset(150, 800);
            contentStream.setFont(PDType1Font.HELVETICA, 14);
            contentStream.showText("Etiquetas de Producto: " + listaProductos.get(0).getNombre());
            contentStream.endText();

            contentStream.setNonStrokingColor(Color.WHITE);
            contentStream.setStrokingColor(Color.BLACK);
            contentStream.setLineWidth(1);

            int x = 50;
            int y = 600;

            final int width = 250;
            final int height = 150;
            for (final TipoProducto producto : listaProductos) {
                // addText(document, page, x, y, 200, 50, false,
                // "Codigos de barra producto: " + producto.getNombre());
                Long codigoDeBarras = Integer.valueOf(producto.getCodigoDeBarras()).longValue();
                final java.awt.image.BufferedImage image = generateEAN13BarcodeImage(
                        codigoDeBarras.toString());
                addImageToPdf(document, x, y, width, height, true,
                        image, contentStream);

                contentStream.addRect(x, y, width, height);

                x += width;
                if (x > 500) {
                    x = 50;
                    y -= height;
                }
            }

            contentStream.stroke();

            contentStream.close();

            return document;
        } catch (final Exception e) {
            return document;
        }

    }

    /**
     * Agrega un texto a el pdf
     * 
     * @param document
     * @param page
     * @param x
     * @param y
     * @param weight
     * @param height
     * @param format
     * @param message
     * @throws IOException
     */
    private void addText(final PDDocument document, final PDPage page, final int x, final int y, final int weight,
            final int height, final boolean format, final String message,
            PDPageContentStream contentStream) throws IOException {

        final PDTextField nameOfCompany = createTextBox(document);

        contentStream.newLineAtOffset(-x, -y);

        contentStream.showText(message);

    }

    /**
     * Agrega un textbox al pdf
     * 
     * @param textBox
     * @param page
     * @param x
     * @param y
     * @param weight
     * @param height
     * @param required
     * @throws IOException
     */
    private void addTextBoxToPage(final PDTextField textBox, final PDPage page, final float x, final float y,
            final float weight, final float height,
            final boolean required) throws IOException {
        final PDAnnotationWidget widget = textBox.getWidgets().get(0);
        final PDRectangle rect = new PDRectangle(x, y, weight, height);
        widget.setRectangle(rect);
        widget.setPage(page);
        widget.setPrinted(true);
        page.getAnnotations().add(widget);

    }

    /**
     * Crea un textbox
     * 
     * @param document
     * @return PDTextField
     */
    private PDTextField createTextBox(final PDDocument document) {

        final PDFont font = PDType1Font.HELVETICA;
        final PDResources resources = new PDResources();
        resources.put(COSName.getPDFName("Helv"), font);
        final PDAcroForm acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
        acroForm.setDefaultResources(resources);
        String defaultAppearanceString = "/Helv 0 Tf 0 g";
        acroForm.setDefaultAppearance(defaultAppearanceString);
        final PDTextField textBox = new PDTextField(acroForm);
        defaultAppearanceString = "/Helv 12 Tf 0 0 0 rg";
        textBox.setDefaultAppearance(defaultAppearanceString);
        textBox.setMultiline(true);
        acroForm.getFields().add(textBox);
        return textBox;
    }

    /**
     * Genera una imagen de un codigo de barras a partir del texto
     * 
     * @param barcodeText
     * @return BufferedImage
     */
    private static java.awt.image.BufferedImage generateEAN13BarcodeImage(final String barcodeText) {
        final Code128Bean barcodeGenerator = new Code128Bean();
        final BitmapCanvasProvider canvas = new BitmapCanvasProvider(600, java.awt.image.BufferedImage.TYPE_BYTE_BINARY,
                false, 0);

        barcodeGenerator.generateBarcode(canvas, barcodeText);

        return canvas.getBufferedImage();
    }

    /**
     * Agrega una imagen al pdf
     * 
     * @param document
     * @param x
     * @param y
     * @param width
     * @param height
     * @param format
     * @param image
     * @param contentStream
     * @throws IOException
     */
    private void addImageToPdf(final PDDocument document, final int x, final int y, final int width, final int height,
            final boolean format, final java.awt.image.BufferedImage image, final PDPageContentStream contentStream)
            throws IOException {
        final PDImageXObject pdfImage = JPEGFactory.createFromImage(document, image);
        contentStream.drawImage(pdfImage, x, y, width, height);
    }

}
