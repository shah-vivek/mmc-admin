package com.mmc.entity;

import com.mmc.model.MembershipType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 08/12/2016.
 */
@Entity(name = "com.mmc.entity.MembershipTypeEntity")
@Table(name = "membership_type")
public class MembershipTypeEntity implements Serializable {

    private static final long serialVersionUID = -539707323874505161L;

    @Id
    @Column(name = "membership_id")
    private String id;

    @Column(name = "membership_name")
    private String name;

    @Column(name = "membership_description")
    private String description;

    @Column(name = "membership_duration")
    private int duration;

    @Column(name = "membership_status")
    private boolean status;

    @Column(name = "membership_cost")
    private float cost;

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MembershipTypeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", status=" + status +
                ", cost=" + cost +
                '}';
    }

    public MembershipTypeEntity() {
    }

    public  MembershipTypeEntity(MembershipType membershipType) {
        this.id = membershipType.getId();
        this.name = membershipType.getName();
        this.description = membershipType.getDescription();
        this.duration = membershipType.getDuration();
        this.cost = membershipType.getCost();
        this.status = membershipType.isStatus();
    }
}
