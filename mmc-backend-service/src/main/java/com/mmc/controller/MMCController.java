package com.mmc.controller;

import com.mmc.model.MMC;
import com.mmc.model.Response;
import com.mmc.service.MMCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SGaurav on 20/10/2017.
 */
@RestController
@RequestMapping(value = "/mmc")
@CrossOrigin(origins = "*")
public class MMCController {

    @Autowired
    private MMCService mmcService;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<Response> add(@RequestBody MMC mmc, HttpServletRequest request,
                                        HttpServletResponse response) {
        Response res = new Response();
        try {
            mmcService.add(mmc);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<Response> update(@RequestBody MMC mmc, HttpServletRequest request,
                                           HttpServletResponse response) {
        Response res = new Response();
        try {
            mmcService.update(mmc);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<?> get( HttpServletRequest request,
                                  HttpServletResponse response) {

        Response res = new Response();
        try {
            return new ResponseEntity<MMC>(mmcService.get(),HttpStatus.OK);
        } catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }
}
