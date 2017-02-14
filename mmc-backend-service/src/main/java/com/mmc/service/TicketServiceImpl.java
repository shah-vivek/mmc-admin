package com.mmc.service;

import com.mmc.entity.TicketEntity;
import com.mmc.model.Ticket;
import com.mmc.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

/**
 * Created by SGaurav on 31/12/2016.
 */
@Service
public class TicketServiceImpl {

    @Autowired
    private TicketRepository ticketRepository;

    public void create(Ticket ticket) throws Exception {

        TicketEntity ticketEntity = new TicketEntity(ticket);
        ticketEntity.setId( UUID.randomUUID().toString());
        System.out.println("Adding tikcet ===================>" + ticketEntity.toString());
        ticketRepository.save(ticketEntity);

    }

    public void update(Ticket ticket) throws Exception {

        TicketEntity ticketEntity = new TicketEntity(ticket);
        ticketRepository.save(ticketEntity);
    }

    public List<Ticket> list() throws Exception {

        List<Ticket> ticketList = new ArrayList<Ticket>();

        Iterable<TicketEntity> ticketEntities = ticketRepository.findAll();

        for( TicketEntity ticketEntity : ticketEntities ){
            ticketList.add( new Ticket(ticketEntity));
        }
        return ticketList;
    }

    public void delete(String ticketId) throws Exception {
        ticketRepository.delete(ticketId);
    }

    public Ticket get(String ticketId) throws Exception {
        Ticket ticket = new Ticket(ticketRepository.findOne(ticketId));
        return ticket;
    }
}
