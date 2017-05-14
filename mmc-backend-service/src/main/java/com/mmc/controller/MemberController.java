package com.mmc.controller;

import com.mmc.entity.PINVerifivationEntity;
import com.mmc.entity.PasswordResetEntity;
import com.mmc.model.*;
import com.mmc.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Created by SGaurav on 05/12/2016.
 */
@RestController
@RequestMapping(value = "/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    private Response res = new Response();

    @RequestMapping(value = "/add",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> addMember(@RequestBody PasswordInfo passwordInfo, HttpServletRequest request,
                                              HttpServletResponse response) {

        try {
            if (memberService.addMember(passwordInfo)) {
                res.setStatus("SUCCESS");
                res.setStatusCode("S-200");
                res.setStatusMsg("Added successfully!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            } else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Email already registered!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
        }catch (Exception e){
                res.setStatus("ERROR");
                res.setStatusCode("IE-500-add");
                res.setStatusMsg(e.getMessage());
                return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> updateMember(@RequestBody  MemberInfo mInfo, HttpServletRequest request,
                                            HttpServletResponse response) {
        try {
            if(memberService.updateMember(mInfo)){
                res.setStatus("SUCCESS");
                res.setStatusCode("S-200");
                res.setStatusMsg("Updated successfully!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }else{
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("User not found!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-update");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> getAllMembers( HttpServletRequest request,
                                                 HttpServletResponse response) {


        try{
            return new ResponseEntity<List<MemberInfo>>(memberService.getAllMembers(), HttpStatus.OK);
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
    public ResponseEntity<?> getMember(@RequestParam("email") String email, HttpServletRequest request,
                                           HttpServletResponse response) {


        try{
            MemberInfo memberInfo = memberService.getMember(email);
            if( memberInfo != null) {
                return new ResponseEntity<MemberInfo>(memberInfo, HttpStatus.OK);
            }else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("User not found!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-get");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> deleteMember(@RequestParam("email") String email, HttpServletRequest request,
                                       HttpServletResponse response) {


        try{
            memberService.deleteMember(email);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Deleted sucessfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-delete");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(value = "/signup",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> signUp(@RequestBody SignUpModel signUpModel, HttpServletRequest request,
                                           HttpServletResponse response) {

        try {
            if (memberService.addMember(signUpModel)) {
                res.setStatus("SUCCESS");
                res.setStatusCode("S-200");
                res.setStatusMsg("Added successfully!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            } else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Email already registered!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/password",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> signUp(@RequestBody GetPassword getPassword, HttpServletRequest request,
                                           HttpServletResponse response) {

        try {
            String password = memberService.getPassword(getPassword);
            if (password != null) {
                if( password.equals("XXXX")) {
                    res.setStatus("ERROR");
                    res.setStatusCode("E-200");
                    res.setStatusMsg("Pin is incorrect");
                    return new ResponseEntity<Response>(res, HttpStatus.OK);
                }
            } else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Email not registered!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
            return new ResponseEntity<String>(password, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/verify-pin",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> verifyPinAndEmailCombination(@RequestBody PINInfo pinInfo, HttpServletRequest request,
                                           HttpServletResponse response) {

        try {
            PINVerifivationEntity pve = memberService.verifyPin(pinInfo);
            if (pve.isPinVerified()) {
                res.setStatus("SUCCESS");
                res.setStatusCode("E-200");
                res.setStatusMsg("Pin and Email Combination is verified");
                    
            } else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Email & PIN are not correct!");
                
            }
            return new ResponseEntity<PINVerifivationEntity>(pve, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/reset-password",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetInfo passwordResetInfo, HttpServletRequest request,
                                           HttpServletResponse response) {

        try {
            PasswordResetEntity pre = memberService.resetPassword(passwordResetInfo);
            if (pre.isPasswordReset()) {
                res.setStatus("SUCCESS");
                res.setStatusCode("E-200");
                res.setStatusMsg("Password Reset Sucessfully");
                    
            } else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Oops something wnt wrong with your credentials! Please try again");
                
            }
            return new ResponseEntity<PasswordResetEntity>(pre, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }


}
