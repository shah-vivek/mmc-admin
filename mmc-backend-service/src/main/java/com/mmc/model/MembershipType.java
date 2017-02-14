package com.mmc.model;

import com.mmc.entity.MembershipTypeEntity;

import java.io.Serializable;

/**
 * Created by SGaurav on 09/12/2016.
 */
public class MembershipType implements Serializable {

    private String id;

    private String name;

    private String description;

    private int duration;

    private boolean status;

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "MembershipType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", status=" + status +
                ", cost=" + cost +
                '}';
    }

    public MembershipType() {
    }

    public MembershipType(MembershipTypeEntity membershipTypeEntity) {
        this.id = membershipTypeEntity.getId();
        this.name = membershipTypeEntity.getName();
        this.description = membershipTypeEntity.getDescription();
        this.cost = membershipTypeEntity.getCost();
        this.duration = membershipTypeEntity.getDuration();
        this.status = membershipTypeEntity.isStatus();
    }
}
