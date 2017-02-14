package com.mmc.entity;

import com.mmc.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SGaurav on 06/12/2016.
 */
@Entity(name = "com.mmc.entity.EventEntity")
@Table(name = "events" )
public class EventEntity implements Serializable {

    private static final long serialVersionUID = -529707323874505161L;

    @Id
    @Column(name = "event_id")
    private String eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventStart;

    @Column(name = "event_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventEnd;

    @Column(name = "event_price")
    private float eventPrice;

    @Column(name = "event_venue")
    private String eventVenue;

    @Column(name = "event_type")
    private String eventType;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

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

    @Override
    public String toString() {
        return "EventEntity{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventStart=" + eventStart +
                ", eventEnd=" + eventEnd +
                ", eventPrice=" + eventPrice +
                ", eventVenue=" + eventVenue +
                ", eventType=" + eventType +
                '}';
    }

    public EventEntity(Event event) {
        this.eventId = event.getEventId();
        this.eventName = event.getEventName();
        this.eventDescription = event.getEventDescription();
        this.eventStart = event.getEventStart();
        this.eventEnd = event.getEventEnd();
        this.eventVenue = event.getEventVenue();
        this.eventPrice = event.getEventPrice();
        this.eventType = event.getEventType();
    }

    public EventEntity(){
    }

}
