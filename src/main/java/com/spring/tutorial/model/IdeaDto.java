package com.spring.tutorial.model;

import java.time.Instant;
import java.util.Objects;

public class IdeaDto {
    private String title;
    private String description;
    private Instant startDate;

    public IdeaDto(String title, String description, Instant startDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        IdeaDto ideaDto = (IdeaDto) object;

        return title.equals(ideaDto.title) &&
                Objects.equals(description, ideaDto.description) &&
                startDate.equals(ideaDto.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, startDate);
    }
}
