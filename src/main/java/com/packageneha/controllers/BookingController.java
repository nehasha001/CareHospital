package com.packageneha.controllers;

import com.packageneha.models.DoctorsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.packageneha.services.AppointmentService;

import java.util.List;
import java.util.Map;

@Controller
public class BookingController {

    String docName, specialization, day, time;
    String userName;


    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "/bookappointment", method = RequestMethod.POST)
    public ModelAndView bookAppointment(@ModelAttribute DoctorsData doctorsData) {

        this.docName = doctorsData.getDocName();
        this.specialization = doctorsData.getSpecialization();
        this.day = doctorsData.getDay();
        this.time = doctorsData.getTime();


        ModelAndView modelAndView = new ModelAndView("bookappointment");
        modelAndView.addObject("doctor", doctorsData);
        return modelAndView;
    }

    @RequestMapping(value = "/confirmAppointment", method = RequestMethod.POST)
    public ModelAndView confirmAppointment(String userName) {

        DoctorsData doctorsData = new DoctorsData(docName, specialization, day, time);

        ModelAndView modelAndView = new ModelAndView("loginHome");
         List list = appointmentService.confirmAppointment(doctorsData, userName);
       modelAndView.addObject("List", list);


        return modelAndView;

    }

    @RequestMapping(value = "/myAppointments")
    public ModelAndView myAppointments() {


        return new ModelAndView("myappointments");

    }

    @RequestMapping(value = "/viewAppointments", method = RequestMethod.POST)
    public ModelAndView viewAppointments(String userName) {

        this.userName = userName;
        Map map = appointmentService.viewAppointments(userName);

        DoctorsData doctorsData = new DoctorsData((String)  map.get("docName"),
                (String) map.get("specialization"),
                (String) map.get("day"),
                (String) map.get("time"));

        ModelAndView modelAndView = new ModelAndView("changeappointments");
        modelAndView.addObject("doctors", doctorsData);

        return modelAndView;


    }

    @RequestMapping(value = "/deleteAppointment")
    public ModelAndView deleteAppointment(@ModelAttribute DoctorsData doctorsData) {

        appointmentService.deleteAppointments(doctorsData, userName);

        return new ModelAndView("loginHome");


    }

//    @RequestMapping(value = "/myAppointments")
//    public ModelAndView myAppointments() {
//
//
//    }
}
