package com.mmc.entity;

import javax.persistence.*;

import com.mmc.model.HomePageEventInfo;

@Entity(name = "com.mmc.entity.HomePageEventInfoEntity")
@Table(name = "home_page" )
public class HomePageEventInfoEntity {
	
	@Id
	@Column(name = "home_page_event_id")
	private String homePageEventId;

	@Column(name = "home_page_content")
    private String content;

	@Column(name = "home_page_image_url")
    private String imageUrl;

	public String getHomePageEventId() {
		return homePageEventId;
	}

	public void setHomePageEventId(String homePageEventId) {
		this.homePageEventId = homePageEventId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public HomePageEventInfoEntity(HomePageEventInfo homePageInfo) {
		super();
		this.homePageEventId = homePageInfo.getHomePageEventId();
		this.content = homePageInfo.getContent();
		this.imageUrl = homePageInfo.getImageUrl();
	}
	
	public HomePageEventInfoEntity(){}
	
	
	
	
}
