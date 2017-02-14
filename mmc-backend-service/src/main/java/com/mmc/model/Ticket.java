package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.TicketEntity;

import java.io.Serializable;

/**
 * Created by SGaurav on 31/12/2016.
 */
@JsonSerialize
public class Ticket implements Serializable {

    private String ticketId;

    private String ticketName;

    private String ticketDesc;

    private Double ticketPrice;

    private int quantity;

    private String eventId;

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketName='" + ticketName + '\'' +
                ", ticketDesc='" + ticketDesc + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", quantity=" + quantity +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public Ticket() {
    }

    public Ticket(TicketEntity ticketEntity){
        this.ticketId = ticketEntity.getId();
        this.ticketName = ticketEntity.getName();
        this.ticketDesc = ticketEntity.getDescription();
        this.ticketPrice = ticketEntity.getPrice();
        this.quantity = ticketEntity.getQty();
        this.eventId = ticketEntity.getEventId();
    }
}
