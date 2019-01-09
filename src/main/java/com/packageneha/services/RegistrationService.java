package com.packageneha.services;

import com.packageneha.models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packageneha.repositories.RegistrationRepository;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;


    public void registerUser(Registration registration) {
        registrationRepository.registerUser(registration);
    }
}
