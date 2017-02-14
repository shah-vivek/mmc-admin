package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.AlbumEntity;

import java.io.Serializable;

/**
 * Created by SGaurav on 15/12/2016.
 */
@JsonSerialize
public class Album implements Serializable {

    private String albumId;

    private String albumName;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                '}';
    }

    public Album() {
    }

    public Album(AlbumEntity albumEntity) {
        this.albumId = albumEntity.getAlbumId();
        this.albumName = albumEntity.getAlbumName();
    }
}
