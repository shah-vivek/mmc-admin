package com.mmc.model;

import java.io.Serializable;

/**
 * Created by SGaurav on 06/12/2016.
 */
public class PasswordInfo implements Serializable{

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
