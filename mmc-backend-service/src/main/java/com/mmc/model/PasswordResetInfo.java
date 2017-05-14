package com.mmc.model;

import java.io.Serializable;

public class PasswordResetInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2331277415751349697L;

	private String email;

    private String pin;
    
    private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
