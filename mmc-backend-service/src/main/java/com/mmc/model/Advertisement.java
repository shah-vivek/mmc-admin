package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.AdvertisementEntity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by SGaurav on 01/01/2017.
 */
@JsonSerialize
public class Advertisement implements Serializable{

    private String id;

    private String title;

    private String description;

    private byte[] imageData;

    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                ", url='" + url + '\'' +
                '}';
    }

    public Advertisement() {
    }

    public Advertisement(AdvertisementEntity advertisementEntity) {
        this.id = advertisementEntity.getAdsId();
        this.title = advertisementEntity.getAdsName();
        this.description = advertisementEntity.getAdsDesc();
        this.url = advertisementEntity.getAdsUrl();
        this.imageData = advertisementEntity.getAdsImage();
    }

    public Advertisement(String id, String title, String description, byte[] imageData, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageData = imageData;
        this.url = url;
    }
    public Advertisement( String title, String description, byte[] imageData, String url) {
        this.title = title;
        this.description = description;
        this.imageData = imageData;
        this.url = url;
    }
}
