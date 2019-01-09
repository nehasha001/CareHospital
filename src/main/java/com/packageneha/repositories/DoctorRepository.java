package com.packageneha.repositories;

import com.packageneha.database.DatabaseConnection;
import com.packageneha.models.DoctorsData;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class DoctorRepository {

    public void getDoctorsList(DoctorsData doctorsData) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();


    }
}