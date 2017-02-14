package com.mmc.controller;

import com.mmc.model.MembershipType;
import com.mmc.model.Response;
import com.mmc.service.MembershipTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by SGaurav on 09/12/2016.
 */
@RestController
@RequestMapping(value = "/membership")
@CrossOrigin(origins = "*")
public class MembershipTypeController {

    @Autowired
    private MembershipTypeServiceImpl membershipTypeService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> add(@RequestBody MembershipType membershipType, HttpServletRequest request,
                                        HttpServletResponse response) {
        Response res = new Response();
        try {
            membershipTypeService.add(membershipType);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> delete(@RequestBody MembershipType membershipType, HttpServletRequest request,
                                        HttpServletResponse response) {
        Response res = new Response();
        try {
            membershipTypeService.delete(membershipType);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> delete( HttpServletRequest request,
                                           HttpServletResponse response) {
        Response res = new Response();
        try {
            return new ResponseEntity<List<MembershipType>>(membershipTypeService.list(), HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("E-200");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }

}
