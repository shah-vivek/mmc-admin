package com.mmc.entity;

import com.mmc.model.Ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 31/12/2016.
 */

@Entity(name = "com.mmc.entity.TicketEntity")
@Table(name ="tickets")
public class TicketEntity implements Serializable {

    private static final long serialVersionUID = -629707323874505161L;

    @Id
    @Column(name = "ticket_id")
    private String id;

    @Column(name = "ticket_name")
    private String name;

    @Column(name = "ticket_description")
    private String description;

    @Column(name = "ticket_price")
    private Double price;

    @Column(name = "ticket_qty")
    private int qty;

    @Column(name = "event_id")
    private String eventId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public TicketEntity() {
    }

    public TicketEntity(Ticket ticket) {

        this.id = ticket.getTicketId();
        this.name = ticket.getTicketName();
        this.description = ticket.getTicketDesc();
        this.price = ticket.getTicketPrice();
        this.qty = ticket.getQuantity();
        this.eventId = ticket.getEventId();
    }
}
