package com.mmc.model;

import java.io.Serializable;

/**
 * Created by SGaurav on 05/01/2017.
 */
public class SignUpModel implements Serializable {

    private final String type  = "user";

    private String email;

    private String firstName;

    private String lastName;

    private String pass;

    private String pin;

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "SignUpModel{" +
                "type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pass='" + pass + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
