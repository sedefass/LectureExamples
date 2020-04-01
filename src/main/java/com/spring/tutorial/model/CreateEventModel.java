package com.spring.tutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.tutorial.domain.Event;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

public class CreateEventModel {

    @NotBlank(message = "The title cannot be missing or empty.")
    private String title;

    @NotBlank(message = "The description cannot be missing or empty.")
    @Size(min = 5, message = "The description must not be less than 5 characters.")
    private String description;

    private String imageUrl;

    @JsonIgnore
    private MultipartFile image;

    @NotNull(message = "The start date cannot be missing or empty.")
    private Instant startDate;

    @NotNull(message = "The end date cannot be missing or empty.")
    private Instant endDate;

    public CreateEventModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Event toEventEntity() {
        Event event = new Event();
        event.setTitle(this.getTitle());
        event.setDescription(this.getDescription());
        event.setImageUrl(this.getImageUrl());
        event.setStartDate(this.getStartDate());
        event.setEndDate(this.getEndDate());

        return event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
