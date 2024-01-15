package com.fpyme.serv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @GetMapping("/")
    public String saludo(Model model) {
        return "index";
    }
}