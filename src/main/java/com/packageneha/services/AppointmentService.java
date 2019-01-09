package com.packageneha.services;

import com.packageneha.models.DoctorsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packageneha.repositories.AppointmentRepository;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<DoctorsData> confirmAppointment(DoctorsData doctorsData, String userName) {

        List list = appointmentRepository.confirmAppointment(doctorsData, userName);

        return list;

    }

    public Map viewAppointments(String userName) {
        Map map = appointmentRepository.viewAppointments(userName);

        return map;
    }

    public void deleteAppointments(DoctorsData doctorsData, String userName) {
        appointmentRepository.deleteAppointment(doctorsData, userName);
    }
}
