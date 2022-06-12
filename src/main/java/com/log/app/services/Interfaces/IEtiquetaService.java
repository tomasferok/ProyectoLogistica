package com.log.app.services.Interfaces;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface IEtiquetaService {
    public ByteArrayOutputStream crearInvoice() throws IOException;
}
