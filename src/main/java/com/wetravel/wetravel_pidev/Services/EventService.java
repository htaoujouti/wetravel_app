package com.wetravel.wetravel_pidev.Services;

import com.wetravel.wetravel_pidev.Repositories.Interfaces.EventCrudInterface;
import java.sql.SQLException;
import com.wetravel.wetravel_pidev.Entities.Event;
import java.util.ArrayList;


public class EventService {

    private final EventCrudInterface eventCrud;

    public EventService(EventCrudInterface eventCrud) {
        this.eventCrud = eventCrud;
    }

    public ArrayList getAllEvents() throws SQLException {
        return eventCrud.findAll();
    }

    public Event getEvent(int id) throws SQLException {
        return eventCrud.find(id);
    }

    public void createEvent(Event event) throws SQLException {
        eventCrud.create(event);
    }

    public void updateEvent(int id,Event event) throws SQLException {
        eventCrud.update(id,event);
    }

    public void deleteEvent(int id) throws SQLException {
        eventCrud.delete(id);
    }
}
