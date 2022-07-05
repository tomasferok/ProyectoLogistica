package com.log.app.exepciones;

import javax.validation.Valid;

/**
 * Clase Abstracta ValidacionIncorrectaExepction
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
 abstract class ValidacionIncorrectaExepction  extends Exception {
    public ValidacionIncorrectaExepction(String message) {
        super(message);
    }

    

}
