package com.spring.tutorial.service;

import com.spring.tutorial.common.exception.InternalServerException;
import com.spring.tutorial.common.exception.ResourceNotFoundException;
import com.spring.tutorial.model.IdeaDto;
import com.spring.tutorial.repository.IdeaRepository;
import org.springframework.stereotype.Service;

@Service
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;

    public IdeaServiceImpl(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    /**
     * Creates new idea and saves in the database.
     *
     * @param ideaDto which will be created and stored in the databases.
     * @return the created idea DTO.
     * @throws InternalServerException when the title or the start date is null.
     */
    @Override
    public IdeaDto create(IdeaDto ideaDto) {
        if (ideaDto.getTitle() == null) {
            throw new InternalServerException("The title of the idea is null.");
        } else if (ideaDto.getStartDate() == null) {
            throw new InternalServerException("The start date of the idea is null.");
        } else {
            return this.ideaRepository.createIdea(ideaDto.getTitle(),
                    ideaDto.getDescription(),
                    ideaDto.getStartDate());
        }
    }

    /**
     * Gets the idea by id.
     *
     * @param id of the idea we want to get.
     * @return the found idea by id.
     * @throws ResourceNotFoundException when there is no idea with the passed id in the database.
     */
    @Override
    public IdeaDto getById(Long id) {
        IdeaDto ideaDto = this.ideaRepository.getIdeaById(id);

        if (ideaDto == null) {
            throw new ResourceNotFoundException("There is no idea in the database with id: " + id);
        }

        return ideaDto;
    }
}
