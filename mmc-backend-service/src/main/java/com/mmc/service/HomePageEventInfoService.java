package com.mmc.service;

import java.util.List;

import com.mmc.model.HomePageEventInfo;


public interface HomePageEventInfoService {
	void addEvent(HomePageEventInfo homePageEventInfo) throws Exception;

    void deleteHomePageEventInfo(String homePageEventInfoId) throws Exception;

    void updateHomePageEventInfo(HomePageEventInfo homePageEventInfo) throws Exception;

    List<HomePageEventInfo> getHomePageEventInfos() throws Exception;

    HomePageEventInfo getHomePageEventInfo(String homePageEventInfoId) throws Exception;
}
