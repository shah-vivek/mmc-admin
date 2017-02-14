package com.mmc.service;

import com.mmc.entity.EventEntity;
import com.mmc.model.Event;
import com.mmc.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 07/12/2016.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(Event event) throws Exception {
        System.out.println("Adding events=================>" + event);
        String uniqueID = UUID.randomUUID().toString();
        event.setEventId(uniqueID);
        EventEntity eventEntity = new EventEntity(event);
        eventRepository.save(eventEntity);

    }

    public void deleteEvent(String eventId) throws Exception {
        EventEntity eventEntity = eventRepository.findOne(eventId);
        System.out.println("Deleting event=================>" + eventEntity);
        eventRepository.delete(eventId);
    }

    public void updateEvent(Event event) throws Exception {
        System.out.println("Updating event=================>" + event);
        EventEntity eventEntity =  new EventEntity(event);
        eventRepository.save(eventEntity);
    }

    public List<Event> getEvents() throws Exception {
        List<Event> events = new ArrayList<>();
        Iterable<EventEntity> eventEntityIterable = eventRepository.findAll();
        for (EventEntity event: eventEntityIterable
                ) {
            events.add(new Event(event));
        }
        System.out.println("Listing events ===================>" + events.toString());
        return events;
    }

    public Event getEvent(String eventId) throws Exception {
        EventEntity eventEntity = eventRepository.findOne(eventId);
        System.out.println("Found event=================>" + eventEntity);
        return new Event(eventEntity);
    }
}
