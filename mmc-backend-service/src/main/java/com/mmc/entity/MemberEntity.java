package com.mmc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SGaurav on 05/12/2016.
 */
@Entity(name = "com.mmc.entity.MemberEntity")
@Table(name = "members" , uniqueConstraints = {@UniqueConstraint(columnNames = {  "member_id" , "member_email"}) })
public class MemberEntity implements Serializable{

    private static final long serialVersionUID = -629707323874505161L;

    @Column(name = "type")
    private String type;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "pass")
    private String pass;

    @Column(name = "status")
    private boolean status;

    @Column(name = "role")
    private String role;

    @Column(name = "pin")
    private String pin;

    @EmbeddedId
    private MemberEntityPK memberEntityPk;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPass() { return pass; }

    public void setPass(String pass) { this.pass = pass; }

    public MemberEntityPK getMemberEntityPk() {
        return memberEntityPk;
    }

    public void setMemberEntityPk(MemberEntityPK memberEntityPk) {
        this.memberEntityPk = memberEntityPk;
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "type='" + type + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", pass='" + pass + '\'' +
                ", status=" + status +
                ", role=" + role +
                ", memberEntityPk=" + memberEntityPk +
                '}';
    }
}
