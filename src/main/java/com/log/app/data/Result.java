package com.log.app.data;

import com.log.app.entidades.Recepcion;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Result {

    String status;
    Object data;
    String error_code;
    String error_description;

    public Result(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(String status, String errCode, String errDescr) {
        this.status = status;
        this.error_code = errCode;
        this.error_description = errDescr;
    }

    public Result(String status, String errCode, String errDescr, Object data) {
        this.status = status;
        this.error_code = errCode;
        this.error_description = errDescr;
        this.data = data;
    }
}
