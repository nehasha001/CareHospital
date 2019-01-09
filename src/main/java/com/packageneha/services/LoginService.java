package com.packageneha.services;


import com.packageneha.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.packageneha.repositories.LoginRepository;

import java.util.Map;

@Service
    public class LoginService {
        @Autowired
        LoginRepository loginRepository;


        public Map checkLogin(Login login) {
            Map hashMap = loginRepository.checkLogin(login);
            return hashMap;
        }

        public ModelAndView validateLogin(Login login, Map hashMap) {
            ModelAndView modelAndView = new ModelAndView();

            if (login.getPassword().equals(hashMap.get("password"))) {
                modelAndView.setViewName("loginHome");
                modelAndView.addObject("login", login);


            }else {
                modelAndView.setViewName("login");
                modelAndView.addObject("error", "Invalid Username or Password");
            }

            return modelAndView;

        }
    }