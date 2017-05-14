package com.mmc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmc.entity.HomePageEventInfoEntity;
import com.mmc.model.HomePageEventInfo;
import com.mmc.repository.HomePageEventInfoRepository;

@Service
public class HomePageEventInfoServiceImpl implements HomePageEventInfoService {

	@Autowired
	HomePageEventInfoRepository homePageEventInfoRepository;
	
	@Override
	public void addEvent(HomePageEventInfo homePageEventInfo) throws Exception {
        String uniqueID = UUID.randomUUID().toString();
        homePageEventInfo.setHomePageEventId(uniqueID);
        HomePageEventInfoEntity homePageEventInfoEntity = new HomePageEventInfoEntity(homePageEventInfo);
        homePageEventInfoRepository.save(homePageEventInfoEntity);
	}

	@Override
	public void deleteHomePageEventInfo(String homePageEventInfoId) throws Exception {
		HomePageEventInfoEntity homePageEventInfoEntity = homePageEventInfoRepository.findOne(homePageEventInfoId);
        System.out.println("Deleting event=================>" + homePageEventInfoEntity);
        homePageEventInfoRepository.delete(homePageEventInfoId);
    }

	@Override
	public void updateHomePageEventInfo(HomePageEventInfo homePageEventInfo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HomePageEventInfo> getHomePageEventInfos() throws Exception {
        List<HomePageEventInfo> homePageEventInfos = new ArrayList<>();
        Iterable<HomePageEventInfoEntity> homePageEventInfoEntityIterable = homePageEventInfoRepository.findAll();
        for (HomePageEventInfoEntity homePageEventInfoEntity: homePageEventInfoEntityIterable
                ) {
        	homePageEventInfos.add(new HomePageEventInfo(homePageEventInfoEntity));
        }
       
        return homePageEventInfos;
    }

	@Override
	public HomePageEventInfo getHomePageEventInfo(String homePageEventInfoId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
