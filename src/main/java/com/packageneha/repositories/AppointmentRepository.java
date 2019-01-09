package com.packageneha.repositories;

import com.packageneha.database.DatabaseConnection;
import com.packageneha.hibernate.HibernateUtil;
import com.packageneha.models.DoctorsData;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

@Repository
public class AppointmentRepository {

    public List<DoctorsData> confirmAppointment(DoctorsData doctorsData, String userName) {
        /*DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();
        databaseConnection.confirmAppointment(connection, doctorsData, userName);*/

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        List<DoctorsData> list;
        Map map;

        try{
            Transaction transaction = session.beginTransaction();
            Query query =session.createQuery("from DoctorsData ");
            list=query.list();
        }


        finally {
            session.close();

        }
        return list;
       /* Transaction transaction = session.beginTransaction();
        Query query =session.createQuery(" FROM Registration ");
        return query.
        transaction.commit();*/
    /*    Criteria criteria= session.CreateCriteria("DoctorData.class");
        criteria.add(Restrictions.eq("docname","specialization"));
        return criteria.list();
        */

    }


    public Map viewAppointments(String userName) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection =databaseConnection.createConnection();
        Map map = databaseConnection.viewAppointments(connection, userName);
        return map;
    }

    public void deleteAppointment(DoctorsData doctorsData, String userName) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();
        Map map = databaseConnection.viewAppointments(connection, userName);
        databaseConnection.openAppointments(connection, map);
        databaseConnection.deleteAppointment(connection, doctorsData, userName);
    }
}