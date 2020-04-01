package com.spring.tutorial.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tutorial.domain.Event;
import com.spring.tutorial.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;

@Component
public class DatabaseRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseRunner.class);

    private final EventService eventService;

    public DatabaseRunner(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting app");
        Event event = new Event();
        event.setTitle("New title");
        event.setDescription("body of the event");
        event.setImageUrl("imageUrl");
        event.setStartDate(Instant.parse("2019-11-20T10:30:30.00Z"));
        event.setEndDate(Instant.parse("2019-12-21T14:37:00.00Z"));

        Event savedEvent = this.eventService.insertNewEvent(event);

        if (savedEvent == null) {
            logger.info("Event can not be saved!");
            logger.info("");
        }

        ArrayList<Event> searchWordEvents = new ArrayList<>(this.eventService.findEventsBySearchWord("BODY"));
        this.printEvents(searchWordEvents);
        logger.info("");

        ArrayList<Event> upcomingEvents = new ArrayList<>(this.eventService.showUpcomingEvents());
        this.printEvents(upcomingEvents);
        logger.info("");

        if (savedEvent != null) {
            this.eventService.deleteById(savedEvent.getId());
        }
        this.eventService.deleteById((long) 5);

        ArrayList<Event> allEvents = new ArrayList<>(this.eventService.getAllEvents());
        this.printEvents(allEvents);
        logger.info("");
    }

    public void printEvents(ArrayList<Event> events) {
        ObjectMapper objectMapper = new ObjectMapper();

        for (Event event: events) {
            try {
                logger.info(objectMapper.writeValueAsString(event));
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }

}
