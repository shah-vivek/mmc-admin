package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.MemberEntity;

import java.io.Serializable;

/**
 * Created by SGaurav on 05/12/2016.
 */
@JsonSerialize
public class MemberInfo implements Serializable {

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String type;

    private boolean status;

    private String role;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public MemberInfo(MemberEntity memberEntity) {
        this.firstName = memberEntity.getFirstName();
        this.lastName = memberEntity.getLastName();
        this.email = memberEntity.getMemberEntityPk().getEmail();
        this.address = memberEntity.getAddress();
        this.phone = memberEntity.getPhone();
        this.type = memberEntity.getType();
        this.status = memberEntity.isStatus();
        this.role = memberEntity.getRole();
    }

    public MemberInfo(){

    }

}
