package com.packageneha.controllers;

import com.packageneha.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.packageneha.services.RegistrationService;


@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;


    @RequestMapping(value = "/registration")
    public ModelAndView viewRegistration() throws Exception{
       /* {
            if(1==1){
                throw new Exception("null");
            }
        }*/
        System.out.println("get registration page");

        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Validated @ModelAttribute("registration") Registration registration, BindingResult errors) {
        System.out.println("calling register...");
        registrationService.registerUser(registration);
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("saving First Name");

        if(errors.hasErrors()){
            System.out.println("errors");
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        return new ModelAndView("home");


    }
   /* @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new RegistrationValidator());
    }
    @ExceptionHandler(value = Exception.class)
    public String exception(){
        return"error";
    }*/
}
