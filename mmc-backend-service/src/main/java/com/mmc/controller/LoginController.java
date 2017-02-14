package com.mmc.controller;

import com.mmc.model.LoginResponse;
import com.mmc.model.PasswordInfo;
import com.mmc.model.Response;
import com.mmc.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SGaurav on 09/12/2016.
 */
@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;


    @RequestMapping(value = "/admin",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<LoginResponse> loginAdmin(@RequestBody PasswordInfo passwordInfo, HttpServletRequest request,
                                              HttpServletResponse response) {

        LoginResponse loginResponse = new LoginResponse();
        try {
            loginResponse = loginService.loginAdmin(passwordInfo , "admin");
            return new ResponseEntity<LoginResponse>(loginResponse , HttpStatus.OK);
        }catch (Exception e){
            Response res = new Response();
            res.setStatusCode("L-200");
            res.setStatus("ERROR");
            res.setStatusMsg("Login unsucessfull");
            loginResponse.setStatus(res);
            System.out.println(e);
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<LoginResponse> login(@RequestBody PasswordInfo passwordInfo, HttpServletRequest request,
                                               HttpServletResponse response) {

        LoginResponse loginResponse = new LoginResponse();
        try {
            loginResponse = loginService.login(passwordInfo);
            return new ResponseEntity<LoginResponse>(loginResponse , HttpStatus.OK);
        }catch (Exception e){
            Response res = new Response();
            res.setStatusCode("L-200");
            res.setStatus("ERROR");
            res.setStatusMsg("Login unsucessfull");
            loginResponse.setStatus(res);
            System.out.println(e);
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
