package com.log.app.exepciones;

import javax.validation.Valid;

 abstract class ValidacionIncorrectaExepction  extends Exception {
    public ValidacionIncorrectaExepction(String message) {
        super(message);
    }

    

}
