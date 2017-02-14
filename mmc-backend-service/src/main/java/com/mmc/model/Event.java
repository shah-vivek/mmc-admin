package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.EventEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SGaurav on 06/12/2016.
 */
@JsonSerialize
public class Event implements Serializable {

    private String eventId;

    private String eventName;

    private String eventDescription;

    private Date eventStart;

    private Date eventEnd;

    private float eventPrice;

    private String eventVenue;

    private String eventType;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventStart(Date eventStart) {
        this.eventStart = eventStart;
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Date eventEnd) {
        this.eventEnd = eventEnd;
    }

    public float getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(float eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Event(EventEntity eventEntity) {
        this.eventId = eventEntity.getEventId();
        this.eventName = eventEntity.getEventName();
        this.eventDescription = eventEntity.getEventDescription();
        this.eventStart = eventEntity.getEventStart();
        this.eventEnd = eventEntity.getEventEnd();
        this.eventVenue = eventEntity.getEventVenue();
        this.eventPrice = eventEntity.getEventPrice();
        this.eventType = eventEntity.getEventType();
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventStart='" + eventStart + '\'' +
                ", eventEnd='" + eventEnd + '\'' +
                ", eventPrice=" + eventPrice +
                ", eventVenue='" + eventVenue + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
