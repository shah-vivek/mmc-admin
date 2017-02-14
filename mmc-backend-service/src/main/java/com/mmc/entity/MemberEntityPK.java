package com.mmc.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SGaurav on 05/12/2016.
 */
@Embeddable
public class MemberEntityPK implements Serializable{

    private static final long serialVersionUID = 1;

    @Column(name = "member_id")
    private int id;

    @Column(name = "member_email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MemberEntityPK{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
