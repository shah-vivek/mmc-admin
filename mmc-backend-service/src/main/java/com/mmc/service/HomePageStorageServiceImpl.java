package com.mmc.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class HomePageStorageServiceImpl {

	@Value("${addHomePage.path}")
	private String HOME_PAGE_DRIVE_LOCATION ;
	
	public void addHomePage(MultipartFile image, MultipartFile content) throws Exception{
		File imageFile = new File(HOME_PAGE_DRIVE_LOCATION+'/'+image.getOriginalFilename());
		File contentFile = new File(HOME_PAGE_DRIVE_LOCATION+'/'+content.getOriginalFilename());
		image.transferTo(imageFile);
		content.transferTo(contentFile);
	}
	
	
}
