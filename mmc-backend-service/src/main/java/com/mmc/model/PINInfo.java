package com.mmc.model;

import java.io.Serializable;

/**
 * Created by SGaurav on 06/12/2016.
 */
public class PINInfo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7243859018008277931L;

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
        return "Pin{" +
                "email='" + email + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
