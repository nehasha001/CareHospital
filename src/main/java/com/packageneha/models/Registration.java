package com.packageneha.models;
import javax.persistence.*;


@Entity
@Table(name = "userdata")
public class Registration {

@Id
@Column(name = "firstname")
public String firstName;

@Column(name = "lastname")

        public String lastName;
@Column(name = "gender")

        public String gender;
@Column(name="eMail")

    public String eMail;
@Column(name="username")

    public String userName;
@Column(name="password")
    public String password;

//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinTable(name = "reg_login", joinColumns = @JoinColumn)

        public Registration() {
        }

        public Registration(String firstName, String lastName, String gender, String eMail, String userName, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.eMail = eMail;
            this.userName = userName;
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String geteMail() {
            return eMail;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }