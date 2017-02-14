package com.mmc.controller;

import com.mmc.model.Advertisement;
import com.mmc.model.Response;
import com.mmc.service.AdvertisementServiceImpl;
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
 * Created by SGaurav on 01/01/2017.
 */
@RestController
@RequestMapping(value = "/ads")
@CrossOrigin(origins = "*")
public class AdvertisementController {

    @Autowired
    private AdvertisementServiceImpl advertisementService;

    Response res = new Response();

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> add(@RequestParam(value="file", required=true) MultipartFile file ,
                                        @RequestParam(value="title", required=true) String title,
                                        @RequestParam(value="url", required=true) String url,
                                        @RequestParam(value="description", required=true) String description, HttpServletRequest request,
                                        HttpServletResponse response) {
        Response res = new Response();
        try {
            Advertisement advertisement = new Advertisement(title ,description , file.getBytes() , url);
            advertisementService.add(advertisement);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> update(@RequestParam(value="file", required=true) MultipartFile file ,
                                           @RequestParam(value="title", required=true) String title,
                                           @RequestParam(value="url", required=true) String url,
                                           @RequestParam(value="description", required=true) String description,
                                           @RequestParam(value="id", required=true) String id,HttpServletRequest request,
                                        HttpServletResponse response) {
        Response res = new Response();
        try {
            Advertisement advertisement = new Advertisement(id ,title ,description , file.getBytes() , url);
            advertisementService.update(advertisement);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Updated successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> delete(@RequestParam String id, HttpServletRequest request,
                                           HttpServletResponse response) {
        Response res = new Response();
        try {
            advertisementService.delete(id);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Deleted successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> list(HttpServletRequest request,
                                           HttpServletResponse response) {
        Response res = new Response();
        try {
            return new ResponseEntity<List<Advertisement>>(advertisementService.list(), HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> get(@RequestParam String id, HttpServletRequest request,
                                    HttpServletResponse response) {
        Response res = new Response();
        try {
            return new ResponseEntity<Advertisement>(advertisementService.get(id), HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
