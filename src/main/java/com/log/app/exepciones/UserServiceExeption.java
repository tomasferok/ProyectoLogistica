package com.log.app.exepciones;

public class UserServiceExeption extends Exception{
    
    private static final long serialVersionUID = 1L;
    
    public UserServiceExeption(String message){
        super(message);
    }
}
