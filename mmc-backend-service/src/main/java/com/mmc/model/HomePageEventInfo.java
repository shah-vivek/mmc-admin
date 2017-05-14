package com.mmc.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.HomePageEventInfoEntity;

@JsonSerialize
public class HomePageEventInfo implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;

    public String getContent() {
    	return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
    private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	private String homePageEventId;
	
	
	public String getHomePageEventId() {
		return homePageEventId;
	}

	public void setHomePageEventId(String homePageEventId) {
		this.homePageEventId = homePageEventId;
	}

	public HomePageEventInfo(HomePageEventInfoEntity homePageEntity) {
        this.content = homePageEntity.getContent();
        this.imageUrl = homePageEntity.getImageUrl();
        this.homePageEventId = homePageEntity.getHomePageEventId();
    }

    public HomePageEventInfo() {
    }

	
}
