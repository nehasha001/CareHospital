package com.packageneha.database;

import com.packageneha.models.DoctorsData;
import com.packageneha.models.Login;
import com.packageneha.models.Registration;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {
    String firstName, lastName, gender;
    String eMail, userName, password;
    String docName, specialization, day, time;


    public Connection createConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","iHateyou7");

        }catch (Exception e){
            System.out.println(e);
            System.out.println("inside Create connection");
        }
        return connection;

    }


    public void registerUser(Connection connection, Registration registration) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Insert into userdata(firstname, lastname, gender, email, username, password) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, registration.getFirstName() );
            preparedStatement.setString(2, registration.getLastName());
            preparedStatement.setString(3, registration.getGender());
            preparedStatement.setString(4, registration.geteMail());
            preparedStatement.setString(5, registration.getUserName());
            preparedStatement.setString(6, registration.getPassword());

            preparedStatement.execute();
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("inside set value");
        }


    }

    public Map getUser(Connection connection, Login login) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select username,password FROM userdata WHERE username = (?)");
            preparedStatement.setString(1, login.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                userName = resultSet.getString("userName");
                password = resultSet.getString("password");
            }
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("inside getvalue");
        }

        Map hashMap = new HashMap();
        hashMap.put("userName", userName);
        hashMap.put("password", password);

        return hashMap;


    }

    public void confirmAppointment(Connection connection, DoctorsData doctorsData, String userName) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT into appointmentsdata(username, docname, specialization, day, time) values (?,?,?,?,?)");
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2, doctorsData.getDocName());
            preparedStatement.setString(3, doctorsData.getSpecialization());
            preparedStatement.setString(4, doctorsData.getDay());
            preparedStatement.setString(5, doctorsData.getTime());

            preparedStatement.execute();

            PreparedStatement preparedStatement1 = connection
                    .prepareStatement("DELETE FROM doctorsdata where docname = (?)");
            preparedStatement1.setString(1, doctorsData.getDocName());

            preparedStatement1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public Map viewAppointments(Connection connection, String userName1) {
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * FROM appointmentsdata where username = (?)");
            preparedStatement.setString(1, userName1);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userName = resultSet.getString("userName");
                docName = resultSet.getString("docName");
                specialization = resultSet.getString("specialization");
                day = resultSet.getString("day");
                time = resultSet.getString("time");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map map = new HashMap();
        map.put("userName", userName);
        map.put("docName", docName);
        map.put("specialization", specialization);
        map.put("day", day);
        map.put("time", time);

        return map;

    }
    public void openAppointments(Connection connection, Map map) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into doctorsdata(docname, specialization, day, time) values (?,?,?,?)");
            preparedStatement.setString(1, (String)map.get("docName"));
            preparedStatement.setString(2, (String)map.get("specialization"));
            preparedStatement.setString(3, (String)map.get("day"));
            preparedStatement.setString(4, (String)map.get("time"));

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(Connection connection, DoctorsData doctorsData, String userName) {

        try {


            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM appointmentsdata where userName = (?)");

            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
