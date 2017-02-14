package com.mmc.service;

import com.mmc.model.Ticket;

import java.util.List;
/**
 * Created by SGaurav on 31/12/2016.
 */
public interface TicketService {

    void create(Ticket ticket) throws Exception;

    void update(Ticket ticket) throws Exception;

    void delete(String id) throws Exception;

    List<Ticket> list() throws Exception;

    Ticket get(String id) throws Exception;
}
