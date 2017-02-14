package com.mmc.controller;

import com.mmc.model.Response;
import com.mmc.model.Ticket;
import com.mmc.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by SGaurav on 31/12/2016.
 */
@RestController
@RequestMapping(value = "/ticket")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    private Response res = new Response();


    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> addTicket(@RequestBody Ticket ticket, HttpServletRequest request,
                                             HttpServletResponse response) {

        try{
            ticketService.create(ticket);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Ticket added successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch(Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-add");
            res.setStatusMsg(e.getMessage());
            System.out.println(e);
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> updateTicket(@RequestBody Ticket ticket, HttpServletRequest request,
                                              HttpServletResponse response) {

        try{
            ticketService.update(ticket);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Ticket update successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch(Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-update");
            res.setStatusMsg(e.getMessage());
            System.out.println(e);
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Response> deleteTicket(@RequestParam("ticketId") String ticketId, HttpServletRequest request,
                                                 HttpServletResponse response) {

        try{
            ticketService.delete(ticketId);
            res.setStatus("SUCCESS");
            res.setStatusCode("S-200");
            res.setStatusMsg("Ticket deleted successfully!");
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }catch(Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-delete");
            res.setStatusMsg(e.getMessage());
            System.out.println(e);
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> getMember(@RequestParam("ticketId") String ticketId, HttpServletRequest request,
                                       HttpServletResponse response) {


        try{
            Ticket memberInfo = ticketService.get(ticketId);
            if( memberInfo != null) {
                return new ResponseEntity<Ticket>(memberInfo, HttpStatus.OK);
            }else {
                res.setStatus("ERROR");
                res.setStatusCode("E-200");
                res.setStatusMsg("Ticket not found!");
                return new ResponseEntity<Response>(res, HttpStatus.OK);
            }
        }catch (Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-get");
            res.setStatusMsg(e.getMessage());
            return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<?> listTicket( HttpServletRequest request,
                                                 HttpServletResponse response) {

        try{
            return new ResponseEntity<List<Ticket>>(ticketService.list(), HttpStatus.OK);
        }catch(Exception e) {
            res.setStatus("ERROR");
            res.setStatusCode("IE-500-list");
            res.setStatusMsg(e.getMessage());
            System.out.println(e);
            return new ResponseEntity<Response>(res, HttpStatus.OK);
        }

    }

}
