package com.log.app.helpers;

import com.log.app.Constants;
import com.log.app.data.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    //RECEPCION
    public final static Result ERR_RECEPCION_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_RECEPCION_NOT_EXISTS", "No existe la recepción ingresada");
    public final static Result ERR_RECEPCION_DIFERENCE = new Result(Constants.RESULT_ERROR, "ERR_RECEPCION_DIFERENCE", "Mercaderia recibida con diferencias");

    public final static Result ERR_GENERAL = new Result(Constants.RESULT_ERROR, "ERR_GENERAL", "Error general");

    //PRODUCTO
    public final static Result ERR_PRODUCTO_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_PRODUCTO_NOT_EXISTS", "El producto ingresado no existe");

    //TIPO PRODUCTO
    public final static Result ERR_PARAM_ID_TIPO_PRODUCTO = new Result(Constants.RESULT_ERROR, "ERR_PARAM_TIPO_PRODUCTO", "El paramaetro ID de Tipo Producto es requerido");
    public final static Result ERR_TIPO_PRODUCTO_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_TIPO_PRODUCTO_NOT_EXISTS", "El Tipo Producto ingresado no existe");

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result errorHandler(HttpServletRequest req, Exception e) throws Exception {
        if(e.getMessage().equals(ERR_RECEPCION_NOT_EXISTS.getError_code()))
            return ERR_RECEPCION_NOT_EXISTS;
        if(e.getMessage().equals(ERR_RECEPCION_DIFERENCE.getError_code()))
            return ERR_RECEPCION_DIFERENCE;
        if(e.getMessage().equals(ERR_PARAM_ID_TIPO_PRODUCTO.getError_code()))
            return ERR_PARAM_ID_TIPO_PRODUCTO;
        if(e.getMessage().equals(ERR_TIPO_PRODUCTO_NOT_EXISTS.getError_code()))
            return ERR_TIPO_PRODUCTO_NOT_EXISTS;
        if(e.getMessage().equals(ERR_PRODUCTO_NOT_EXISTS.getError_code()))
            return ERR_PRODUCTO_NOT_EXISTS;
        ERR_GENERAL.setError_description(e.getMessage());
        return ERR_GENERAL;
    }
}
