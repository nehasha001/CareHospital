package com.packageneha.services;

import com.packageneha.models.DoctorsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packageneha.repositories.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public void doctorService(DoctorsData doctorsData) {

        doctorRepository.getDoctorsList(doctorsData);




    }
}
