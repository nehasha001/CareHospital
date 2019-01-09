package com.packageneha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView viewHomePage() {

        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;

    }
}
