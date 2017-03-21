package com.mmc.controller;

import com.mmc.model.Advertisement;
import com.mmc.model.Response;
import com.mmc.service.AdvertisementServiceImpl;
import com.mmc.service.HomePageStorageServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by Vivek Shah on 18/03/2017.
 */
@RestController
@RequestMapping(value = "/appHomePage")
@CrossOrigin(origins = "*")
public class AppHomePageController {

	private HomePageStorageServiceImpl homePageStorageService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	public ResponseEntity<?> list(@RequestParam(value = "file", required = true) MultipartFile imageFile,
			@RequestParam(value = "file", required = true) MultipartFile contentFile

	) {
		Response res = new Response();
		try {
			homePageStorageService.addHomePage(imageFile, contentFile);
			res.setStatus("SUCCESS");
			res.setStatusCode("200");
			return new ResponseEntity<Response>(res, HttpStatus.OK);
		} catch (Exception e) {
			res.setStatus("ERROR");
			res.setStatusCode("E-200");
			res.setStatusMsg(e.getMessage());
			return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}