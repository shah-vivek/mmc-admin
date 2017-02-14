package com.mmc.entity;

import com.mmc.model.Advertisement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 01/01/2017.
 */

@Entity(name = "com.mmc.entity.AdvertisementEntity")
@Table(name = "ads")
public class AdvertisementEntity implements Serializable {

    private static final long serialVersionUID = -529707323874505161L;

    @Id
    @Column(name = "ads_id")
    private String adsId;

    @Column(name = "ads_title")
    private String adsName;

    @Column(name = "ads_desc")
    private String adsDesc;

    @Column(name = "ads_url")
    private String adsUrl;

    @Column(name = "ads_image")
    private byte[] adsImage;

    public void setAdsId(String adsId) {
        this.adsId = adsId;
    }

    public String getAdsId() {
        return adsId;
    }

    public String getAdsName() {
        return adsName;
    }

    public void setAdsName(String adsName) {
        this.adsName = adsName;
    }

    public String getAdsDesc() {
        return adsDesc;
    }

    public void setAdsDesc(String adsDesc) {
        this.adsDesc = adsDesc;
    }

    public String getAdsUrl() {
        return adsUrl;
    }

    public void setAdsUrl(String adsUrl) {
        this.adsUrl = adsUrl;
    }

    public byte[] getAdsImage() {
        return adsImage;
    }

    public void setAdsImage(byte[] adsImage) {
        this.adsImage = adsImage;
    }

    @Override
    public String toString() {
        return "AdvertisementEntity{" +
                "adsId='" + adsId + '\'' +
                ", adsName='" + adsName + '\'' +
                ", adsDesc='" + adsDesc + '\'' +
                ", adsUrl='" + adsUrl + '\'' +
                ", adsImage='" + adsImage + '\'' +
                '}';
    }

    public AdvertisementEntity() {
    }

    public AdvertisementEntity(Advertisement advertisement) {
        this.adsId = advertisement.getId();
        this.adsName = advertisement.getTitle();
        this.adsDesc = advertisement.getDescription();
        this.adsUrl = advertisement.getUrl();
        this.adsImage = advertisement.getImageData();
    }
}
