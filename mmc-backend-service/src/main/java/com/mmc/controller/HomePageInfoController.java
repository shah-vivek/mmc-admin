package com.mmc.controller;

import com.mmc.model.HomePageEventInfo;
import com.mmc.model.Response;
import com.mmc.service.HomePageEventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/home_page")
@CrossOrigin(origins = "*")
public class HomePageInfoController {
    
    @Autowired
    private HomePageEventInfoService homePageEventInfoService;
    
    private Response res = new Response();

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> addEvent(@RequestBody HomePageEventInfo homePageEventInfo, HttpServletRequest request,
                                              HttpServletResponse response) {

        try {
            homePageEventInfoService.addEvent(homePageEventInfo);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Homepage event added successfully!");
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
            homePageEventInfoService.deleteHomePageEventInfo(eventId);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Homepage event deleted sucessfully!");
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


    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> getAllEvents( @RequestParam("eventId") String eventId, HttpServletRequest request,
                                           HttpServletResponse response) {
        try{
            return new ResponseEntity<HomePageEventInfo>(homePageEventInfoService.getHomePageEventInfo(eventId), HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-get");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> getAllEvents( @RequestBody HomePageEventInfo homePageEventInfo, HttpServletRequest request,
                                           HttpServletResponse response) {
        try{
            homePageEventInfoService.updateHomePageEventInfo(homePageEventInfo);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Homepage event updated sucessfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-delete");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


   

    

}
