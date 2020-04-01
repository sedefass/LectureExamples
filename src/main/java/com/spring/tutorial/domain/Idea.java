package com.spring.tutorial.domain;

import com.spring.tutorial.common.DtoConvertible;
import com.spring.tutorial.model.IdeaDto;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ideas")
public class Idea implements DtoConvertible<IdeaDto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private Instant startDate;

    public Idea() {
    }

    public Idea(String title, String description, Instant startDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    @Override
    public IdeaDto toDto() {
        return new IdeaDto(title, description, startDate);
    }
}
