package com.mmc.service;

import com.mmc.model.Event;
import java.util.List;
/**
 * Created by SGaurav on 06/12/2016.
 */
public interface EventService {

    void addEvent(Event event) throws Exception;

    void deleteEvent(String eventId) throws Exception;

    void updateEvent(Event event) throws Exception;

    List<Event> getEvents() throws Exception;

    Event getEvent(String eventId) throws Exception;
}
