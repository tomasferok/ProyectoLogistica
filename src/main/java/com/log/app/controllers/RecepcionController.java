package com.log.app.controllers;

import com.log.app.services.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecepcionController {
    
    @Autowired
    private RecepcionService recepcionService;
}
