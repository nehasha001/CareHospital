package com.packageneha.repositories;

import com.packageneha.database.DatabaseConnection;
import com.packageneha.models.Login;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Map;

@Repository
public class LoginRepository {

    public Map checkLogin(Login login) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();
        Map hashMap = databaseConnection.getUser(connection, login);
        return hashMap;

    }}