package com.spring.tutorial.repository;

import com.spring.tutorial.domain.Idea;
import com.spring.tutorial.model.IdeaDto;
import org.springframework.stereotype.Repository;
import java.time.Instant;

@Repository
public class IdeaRepository {

    private final IdeaCrudRepository ideaCrudRepository;

    public IdeaRepository(IdeaCrudRepository ideaCrudRepository) {
        this.ideaCrudRepository = ideaCrudRepository;
    }

    /**
     *  Create new record in the database for idea
     *
     * @param title The title of the Idea
     * @param description The description of Idea
     * @param startDate The date when we have started the Idea
     * @return The created idea
     */
    public IdeaDto createIdea(String title, String description, Instant startDate) {
        return ideaCrudRepository.save(new Idea(title, description, startDate)).toDto();
    }

    /**
     * Take the idea by id
     *
     * @param  id Unique identifier of the Idea.
     * @return The Idea which was found by id.
     */
    public IdeaDto getIdeaById(Long id) {
        return ideaCrudRepository.findById(id).map(Idea::toDto).orElse(null);
    }
}


