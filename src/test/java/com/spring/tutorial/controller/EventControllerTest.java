package com.spring.tutorial.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring.tutorial.TutorialApplication;
import com.spring.tutorial.common.RestApiEndpoints;
import com.spring.tutorial.domain.Event;
import com.spring.tutorial.model.CreateEventModel;
import com.spring.tutorial.repository.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorialApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EventControllerTest {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    private WebApplicationContext context;

    private ArrayList<Long> eventIds = new ArrayList<>();
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mapper.registerModule(new JavaTimeModule());

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

    @Test
    @Transactional
    public void getAllEvents() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get(RestApiEndpoints.ALL_EVENTS))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        List<Event> events = mapper.readValue(content, new TypeReference<List<Event>>(){});

        Assert.assertEquals("New title1", events.get(0).getTitle());
        Assert.assertEquals(5, events.size());
    }

    @Test
    @Transactional
    public void getEventById() throws Exception {
        String eventId = Long.toString(eventIds.get(0));
        MvcResult mvcResult = mockMvc.perform(get(RestApiEndpoints.EVENT)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Event event = mapper.readValue(content, Event.class);
        Assert.assertEquals("New title1", event.getTitle());

        eventId = "0";
        mvcResult = mockMvc.perform(get(RestApiEndpoints.EVENT)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("", content);
    }

    @Test
    @Transactional
    public void getEventById2() throws Exception {
        String eventId = Long.toString(eventIds.get(0));
        MvcResult mvcResult = mockMvc.perform(get(RestApiEndpoints.EVENT_ID, eventId)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Event event = mapper.readValue(content, Event.class);
        Assert.assertEquals("New title1", event.getTitle());

        eventId = "0";
        mvcResult = mockMvc.perform(get(RestApiEndpoints.EVENT_ID, eventId)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("", content);
    }

    @Test
    @Transactional
    public void getEventsByStartDate() throws Exception {
        String startDate = "1999-11-20T10:30:30.00Z";
        MvcResult mvcResult = mockMvc.perform(get(RestApiEndpoints.ALL_EVENTS_START_DATE)
                .param("startDate", startDate))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        List<Event> events = mapper.readValue(content, new TypeReference<List<Event>>(){});

        Assert.assertEquals("New title1", events.get(0).getTitle());
        Assert.assertEquals(5, events.size());

        startDate = "2100-11-20T10:30:30.00Z";
        mvcResult = mockMvc.perform(get(RestApiEndpoints.ALL_EVENTS_START_DATE)
                .param("startDate", startDate))
                .andExpect(status().isOk()).andReturn();
        content = mvcResult.getResponse().getContentAsString();
        events = mapper.readValue(content, new TypeReference<List<Event>>(){});

        Assert.assertEquals("New title4", events.get(0).getTitle());
        Assert.assertEquals(2, events.size());
    }

    @Test
    @Transactional
    public void deleteById() throws Exception {
        String eventId = Long.toString(eventIds.get(0));

        MvcResult mvcResult = mockMvc.perform(delete(RestApiEndpoints.EVENT_ID, eventId)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(Boolean.parseBoolean(content));

        mvcResult = mockMvc.perform(get(RestApiEndpoints.EVENT_ID, eventId)
                .param("id", eventId))
                .andExpect(status().isOk()).andReturn();
        content = mvcResult.getResponse().getContentAsString();
        assertFalse(Boolean.parseBoolean(content));
    }

    @Test
    @Transactional
    public void createEvent() throws Exception {
        CreateEventModel createEventModel = new CreateEventModel();
        createEventModel.setTitle("New title6");
        createEventModel.setDescription("body of the event");
        createEventModel.setImageUrl("imageUrl");
        createEventModel.setStartDate(Instant.parse("2222-11-20T10:30:30.00Z"));
        createEventModel.setEndDate(Instant.parse("2222-12-21T14:37:00.00Z"));

        String jsonValue = mapper.writeValueAsString(createEventModel);
        MvcResult mvcResult = mockMvc.perform(post(RestApiEndpoints.EVENT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonValue))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Event event = mapper.readValue(content, Event.class);
        assertFalse(eventIds.contains(event.getId()));

        createEventModel.setTitle("title");
        jsonValue = mapper.writeValueAsString(createEventModel);
        mockMvc.perform(post(RestApiEndpoints.EVENT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonValue))
                .andExpect(status().isBadRequest());

        createEventModel.setTitle("New title6");
        createEventModel.setDescription("body");
        jsonValue = mapper.writeValueAsString(createEventModel);
        mockMvc.perform(post(RestApiEndpoints.EVENT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonValue))
                .andExpect(status().isBadRequest());
    }

}