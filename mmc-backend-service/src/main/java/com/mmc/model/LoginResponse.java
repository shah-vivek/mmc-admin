package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by SGaurav on 09/12/2016.
 */
@JsonSerialize
public class LoginResponse implements Serializable{

    private MemberInfo userDetails;

    private Response status;

    public MemberInfo getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(MemberInfo userDetails) {
        this.userDetails = userDetails;
    }

    public Response getStatus() {
        return status;
    }

    public void setStatus(Response status) {
        this.status = status;
    }
}
