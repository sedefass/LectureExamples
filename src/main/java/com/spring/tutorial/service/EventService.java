package com.spring.tutorial.service;

import com.spring.tutorial.domain.Event;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public interface EventService {
    Event insertNewEvent(Event event);

    boolean deleteById(Long id);

    ArrayList<Event> getAllEvents();

    ArrayList<Event> getEventsByIds(ArrayList<Long> ids);

    Event getEventById(Long id);

    List<Event> findEventsBySearchWord(String searchWord);

    List<Event> getEventsByStartDate(Instant startDate);

    List<Event> showUpcomingEvents();

}
