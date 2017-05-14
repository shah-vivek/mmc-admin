package com.mmc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmc.model.Event;
import com.mmc.model.HomePageEventInfo;
import com.mmc.model.Response;
import com.mmc.service.EventServiceImpl;
import com.mmc.service.HomePageEventInfoService;


@RestController
@RequestMapping(value = "/events")
@CrossOrigin(origins = "*")
public class HomePageInfoController {
    @Autowired
    private EventServiceImpl eventService;
    
    @Autowired
    private HomePageEventInfoService homePageEventInfoService;
    
    private Response res = new Response();

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> addEvent(@RequestBody Event event, HttpServletRequest request,
                                              HttpServletResponse response) {

        try {
            eventService.addEvent(event);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Event added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            System.out.println(e);
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> deleteEvent(@RequestParam("eventId") String eventId, HttpServletRequest request,
                                          HttpServletResponse response) {


        try{
            eventService.deleteEvent(eventId);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Event deleted sucessfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-delete");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> getAllEvents( HttpServletRequest request,
                                            HttpServletResponse response) {
        try{
            return new ResponseEntity<List<HomePageEventInfo>>(homePageEventInfoService.getHomePageEventInfos(), HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-list");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


   

    

}
