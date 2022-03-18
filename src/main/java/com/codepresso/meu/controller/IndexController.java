package com.codepresso.meu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    public IndexController() {

    };

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
}
