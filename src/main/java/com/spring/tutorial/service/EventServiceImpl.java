package com.spring.tutorial.service;

import com.spring.tutorial.domain.Event;
import com.spring.tutorial.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
    
    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Event insertNewEvent(Event event) throws IllegalArgumentException {
        if (Character.isLowerCase(event.getTitle().charAt(0))) {
            throw new IllegalArgumentException("The title must start with uppercase letter.");
        }

        if (event.getDescription().length() < 5) {
            throw new IllegalArgumentException("The description must contain 5 letters or more.");
        }

        return this.eventRepository.save(event);
    }

    public boolean deleteById(Long id) {
        try {
            this.eventRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public ArrayList<Event> getAllEvents() {
        Iterator<Event> iterator = this.eventRepository.findAll().iterator();
        ArrayList<Event> events = new ArrayList<>();

        while (iterator.hasNext()) {
            Event event = iterator.next();
            events.add(event);
        }

        return events;
    }

    public ArrayList<Event> getEventsByIds(ArrayList<Long> ids) {
        Iterator<Event> iterator = this.eventRepository.findAllById(ids).iterator();
        ArrayList<Event> events = new ArrayList<>();

        while (iterator.hasNext()) {
            Event event = iterator.next();
            events.add(event);
        }

        return events;
    }

    public Event getEventById(Long id) {
        if ( this.eventRepository.findById(id).isPresent()) {
            return this.eventRepository.findById(id).get();
        }

        return null;
    }

    public List<Event> findEventsBySearchWord(String searchWord) {
        return this.eventRepository.findEventsBySearchWord(searchWord);
    }

    public List<Event> getEventsByStartDate(Instant startDate) {
        return this.eventRepository.findEventsBySearchDate(startDate);
    }

    public List<Event> showUpcomingEvents() {
        Instant currentDate = Instant.now().truncatedTo(ChronoUnit.DAYS);

        return this.eventRepository.findEventsBySearchDate(currentDate);
    }
}
