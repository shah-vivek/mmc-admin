package com.mmc.controller;

import com.mmc.model.Message;
import com.mmc.model.Response;
import com.mmc.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by SGaurav on 06/01/2017.
 */
@RestController
@RequestMapping(value = "/message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    private Response res = new Response();

    @RequestMapping(value="/send",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> sendMessage(@RequestBody Message message , HttpServletRequest request,
                                HttpServletResponse response) {
        try{
            messageService.send(message);
            res.setStatusCode("S-200");
            res.setStatus("SUCCESS");
            res.setStatusMsg("Message sent!");
            return new ResponseEntity<Response>(res , HttpStatus.OK);
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value="",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> list(HttpServletRequest request,
                                  HttpServletResponse response) {
        try{
            List<Message> messageList = messageService.get();
            return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
        }catch (Exception e){
            res.setStatus("ERROR");
            res.setStatusCode("IE-500");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }
    }
}

