package com.packageneha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.packageneha.services.DoctorService;

@Controller
public class DoctorsController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/doctors")
    public ModelAndView doctors() {
        return new ModelAndView("doctors");
    }
//
//    @RequestMapping(value = "/searchDoctors")
//    public ModelAndView searchDoctors(@ModelAttribute DoctorsData doctor) {
//
//        doctorService.doctorService(doctor);
//
//
//
//
//
//    }
}
