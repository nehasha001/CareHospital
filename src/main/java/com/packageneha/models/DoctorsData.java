package com.packageneha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "doctorsdata")
public class DoctorsData {
    @Id
    @Column(name = "docname")
    String docName;
    @Id
    @Column(name = "specialization")
    String specialization;
    @Id
    @Column(name = "day")
    String day;
    @Id
    @Column(name = "time")
    String time;

    public String getDocName() {

        return docName;
    }

    public void setDocName(String docName) {

        this.docName = docName;
    }

    public String getSpecialization() {

        return specialization;
    }

    public void setSpecialization(String specialization) {

        this.specialization = specialization;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DoctorsData() {

    }

    public DoctorsData(String docName, String specialization, String day, String time) {

        this.docName = docName;
        this.specialization = specialization;
        this.day = day;
        this.time = time;
    }

}
