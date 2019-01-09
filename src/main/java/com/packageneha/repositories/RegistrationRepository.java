package com.packageneha.repositories;

import com.packageneha.database.DatabaseConnection;
import com.packageneha.hibernate.HibernateUtil;
import com.packageneha.models.Registration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class RegistrationRepository {



    public void registerUser(Registration registration) {
       /* DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection =databaseConnection.createConnection();
        databaseConnection.registerUser(connection, registration);*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //registration.setLogin(login);
        session.save(registration);
        transaction.commit();

    }



}
