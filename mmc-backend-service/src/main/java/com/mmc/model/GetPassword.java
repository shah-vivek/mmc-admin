package com.mmc.model;

import java.io.Serializable;

/**
 * Created by SGaurav on 11/01/2017.
 */
public class GetPassword implements Serializable {

    private String email;

    private String pin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "GetPassword{" +
                "email='" + email + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }

    public GetPassword() {
    }
}
