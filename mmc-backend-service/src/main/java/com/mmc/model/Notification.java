package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.NotificationEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SGaurav on 09/12/2016.
 */
@JsonSerialize
public class Notification implements Serializable {

    private String id;

    private String title;

    private Date date;

    private String description;

    private String url;

    public Notification() {
    }

    public Notification(NotificationEntity notificationEntity) {
        this.id = notificationEntity.getId();
        this.title = notificationEntity.getTitle();
        this.date = notificationEntity.getDate();
        this.description = notificationEntity.getDescription();
        this.url = notificationEntity.getUrl();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
