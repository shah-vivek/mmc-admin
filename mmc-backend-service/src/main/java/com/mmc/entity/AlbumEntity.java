package com.mmc.entity;

import com.mmc.model.Album;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 15/12/2016.
 */
@Entity(name = "com.mmc.entity.AlbumEntity")
@Table(name = "albums" )
public class AlbumEntity implements Serializable{

    private static final long serialVersionUID = -529707323874505161L;

    @Id
    @Column(name = "album_id")
    private String albumId;

    @Column(name = "album_name")
    private String albumName;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }

    public AlbumEntity() {
    }

    public AlbumEntity(Album album) {
        this.albumId = album.getAlbumId();
        this.albumName = album.getAlbumName();
    }
}
