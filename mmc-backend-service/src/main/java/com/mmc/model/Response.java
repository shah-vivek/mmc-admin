package com.mmc.model;

import java.io.Serializable;

/**
 * Created by SGaurav on 06/12/2016.
 */
public class Response implements Serializable {

    private String status;

    private String statusCode;

    private String statusMsg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                '}';
    }
}
