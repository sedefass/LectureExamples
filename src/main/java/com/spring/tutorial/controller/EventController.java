package com.spring.tutorial.controller;

import com.spring.tutorial.common.RestApiEndpoints;
import com.spring.tutorial.domain.Event;
import com.spring.tutorial.model.CreateEventModel;
import com.spring.tutorial.service.EventService;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.blob.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Validated
@RestController
public class EventController {

    private final EventService eventService;

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = RestApiEndpoints.ALL_EVENTS, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEvents() {
        return this.eventService.getAllEvents();
    }

    @GetMapping(value = RestApiEndpoints.EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEventById(@RequestParam Long id) {
        return this.eventService.getEventById(id);
    }

    @GetMapping(value = RestApiEndpoints.EVENT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEventById2(@PathVariable("id") Long id) {
        return this.eventService.getEventById(id);
    }

    @GetMapping(value = RestApiEndpoints.ALL_EVENTS_START_DATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getEventsByStartDate(@RequestParam(required = false) Instant startDate) {
        if (startDate == null) {
            startDate = Instant.now().truncatedTo(ChronoUnit.DAYS);
        }

        return this.eventService.getEventsByStartDate(startDate);
    }

    @DeleteMapping(value = RestApiEndpoints.EVENT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteById(@PathVariable("id") Long id) {
        return this.eventService.deleteById(id);
    }

    @PostMapping(value = RestApiEndpoints.EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@Valid @RequestBody CreateEventModel createEventModel) {
        Event event = createEventModel.toEventEntity();
        return eventService.insertNewEvent(event);
    }

    @PostMapping(value = "/things2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String submitThing2(@Valid @ModelAttribute CreateEventModel createEventModel)
            throws Exception {
        // TODO put those in yaml file
        String DefaultEndpointsProtocol = "DefaultEndpointsProtocol=https;";
        String AccountName = "AccountName=ithubeventsstorage;";
        String AccountKey = "AccountKey=jdNceyWcCIUaSdp127qbHQl6ezBpuzjiT5G/OTz5/pBkd2wb/uRaw4xfgrnezNtLkDJOrG0OJpOYeremBoQy8A==;EndpointSuffix=core.windows.net";
        String cs = MessageFormat.format("{0};{1};{2}", DefaultEndpointsProtocol, AccountName, AccountKey);
        String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=ithubeventsstorage;AccountKey=jdNceyWcCIUaSdp127qbHQl6ezBpuzjiT5G/OTz5/pBkd2wb/uRaw4xfgrnezNtLkDJOrG0OJpOYeremBoQy8A==;EndpointSuffix=core.windows.net";
        String containerName = "ithubevents-blob";

        logger.info("" + cs.equals(storageConnectionString));

        CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer container = blobClient.getContainerReference(containerName);
        container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());

        // TODO generate those with unique uuids
        CloudBlockBlob blob = container.getBlockBlobReference(createEventModel.getImage().getOriginalFilename());
        if (!blob.exists()) {
            blob.getProperties().setContentType(createEventModel.getImage().getContentType());
            blob.getProperties().setContentDisposition("attachment; filename=" + UriUtils.encode(createEventModel.getImage().getOriginalFilename(), "UTF-8"));
            blob.uploadFromByteArray(createEventModel.getImage().getBytes(), 0, createEventModel.getImage().getBytes().length);
        }

        return blob.getUri().toString();

    }

}
