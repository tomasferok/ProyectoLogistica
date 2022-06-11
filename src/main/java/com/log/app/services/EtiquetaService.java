package com.log.app.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.log.app.entidades.RecepcionProducto;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

/**
 * EtiquetaService
 */

@Service
public class EtiquetaService {
    EtiquetaService() {

    }

    public ByteArrayOutputStream crearInvoice() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PDDocument MyPDF = new PDDocument();
        PDPage newpage = new PDPage();
        MyPDF.addPage(newpage);
        PDPage mypage = MyPDF.getPage(0);
        PDPageContentStream cs = new PDPageContentStream(MyPDF, mypage);
        cs.beginText();
        cs.setFont(PDType1Font.TIMES_ROMAN, 18);
        cs.newLineAtOffset(150, 750);
        String InvoiceTitle = new String("CodeSpeedy Technology Private Limited");
        cs.showText(InvoiceTitle);
        // Ending the text
        cs.endText();
        // Closing the content stream
        cs.close();
        MyPDF.save(output);
        MyPDF.close();
        
        return output;
    }

}