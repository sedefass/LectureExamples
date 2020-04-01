package com.spring.tutorial.service;

import com.spring.tutorial.TutorialApplication;
import com.spring.tutorial.domain.Event;
import com.spring.tutorial.repository.EventRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorialApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EventServiceTest {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    private ArrayList<Long> eventIds = new ArrayList<>();

    @Before
    @Transactional
    public void before() {

        for (int i = 1; i <= 5; i++) {
            Event event = new Event();
            event.setTitle("New title" + i);
            event.setDescription("body of the event");
            event.setImageUrl("imageUrl");
            if (i <= 3) {
                event.setStartDate(Instant.parse("2000-11-20T10:30:30.00Z"));
                event.setEndDate(Instant.parse("2000-12-21T14:37:00.00Z"));
            } else {
                event.setStartDate(Instant.parse("2222-11-20T10:30:30.00Z"));
                event.setEndDate(Instant.parse("2222-12-21T14:37:00.00Z"));
            }

            Event savedEvent = this.eventRepository.save(event);
            eventIds.add(savedEvent.getId());
        }
    }

    @After
    public void after() {
//        this.eventRepository.deleteAll();
    }

    @Test
    @Transactional
    public void insertNewEvent() {
        Event event = new Event();
        event.setTitle("New title");
        event.setDescription("body of the event");
        event.setImageUrl("imageUrl");
        event.setStartDate(Instant.parse("2019-11-20T10:30:30.00Z"));
        event.setEndDate(Instant.parse("2019-12-21T14:37:00.00Z"));

        Assert.assertNotEquals(null, this.eventService.insertNewEvent(event));
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    public void insertNewEventTitleError() {
        Event event = new Event();
        event.setTitle("title"); // setting the title to start with non-capital letter, so inserting the event into the database will not work
        event.setDescription("body of the event");
        event.setImageUrl("imageUrl");
        event.setStartDate(Instant.parse("2019-11-20T10:30:30.00Z"));
        event.setEndDate(Instant.parse("2019-12-21T14:37:00.00Z"));

        this.eventService.insertNewEvent(event);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    public void insertNewEventDescriptionError() {
        Event event = new Event();
        event.setTitle("Title");
        event.setDescription("body"); // setting the description length < 5, so inserting the event into the database will not work
        event.setImageUrl("imageUrl");
        event.setStartDate(Instant.parse("2019-11-20T10:30:30.00Z"));
        event.setEndDate(Instant.parse("2019-12-21T14:37:00.00Z"));

        this.eventService.insertNewEvent(event);
    }

    @Test
    @Transactional
    public void deleteById() {
        assertTrue(this.eventService.deleteById(eventIds.get(0)));
        assertFalse(this.eventService.deleteById(eventIds.get(0)));
    }

    @Test
    @Transactional
    public void getAllEvents() {
        Assert.assertEquals(5, this.eventService.getAllEvents().size());
        Assert.assertEquals("New title1", this.eventService.getAllEvents().get(0).getTitle());
    }

    @Test
    @Transactional
    public void getEventsByIds() {
        Assert.assertEquals(5, this.eventService.getEventsByIds(eventIds).size());
        Assert.assertEquals("New title1", this.eventService.getEventsByIds(eventIds).get(0).getTitle());

        List<Long> head = eventIds.subList(0, 2);
        List<Long> tail = eventIds.subList(2, 5);
        Assert.assertEquals(2, this.eventService.getEventsByIds(new ArrayList<>(head)).size());
        Assert.assertEquals(3, this.eventService.getEventsByIds(new ArrayList<>(tail)).size());
    }

    @Test
    @Transactional
    public void findEventsBySearchWord() {
        Assert.assertEquals(5, this.eventService.findEventsBySearchWord("body").size());
        // TODO fix this to work with both databases: Assert.assertEquals(5, this.eventService.findEventsBySearchWord("BODY").size());
        Assert.assertEquals("New title1", this.eventService.findEventsBySearchWord("1").get(0).getTitle());
        Assert.assertEquals("New title2", this.eventService.findEventsBySearchWord("2").get(0).getTitle());
        Assert.assertEquals("New title3", this.eventService.findEventsBySearchWord("3").get(0).getTitle());
        Assert.assertEquals("New title4", this.eventService.findEventsBySearchWord("4").get(0).getTitle());
        Assert.assertEquals("New title5", this.eventService.findEventsBySearchWord("5").get(0).getTitle());
        Assert.assertEquals(5, this.eventService.findEventsBySearchWord("New title").size());
        Assert.assertEquals(0, this.eventService.findEventsBySearchWord("title New").size());
    }

    @Test
    @Transactional
    public void getEventsByStartDate(){
        Assert.assertEquals(5, this.eventService.getEventsByStartDate(Instant.parse("1999-11-20T10:30:30.00Z")).size());
        Assert.assertEquals(2, this.eventService.getEventsByStartDate(Instant.parse("2001-11-20T10:30:30.00Z")).size());
        Assert.assertEquals(0, this.eventService.getEventsByStartDate(Instant.parse("2223-11-20T10:30:30.00Z")).size());
    }

    @Test
    @Transactional
    public void showUpcomingEvents() {
        Assert.assertEquals(2, this.eventService.showUpcomingEvents().size());
        this.eventRepository.deleteAll();
        Assert.assertEquals(0, this.eventService.showUpcomingEvents().size());
    }

}