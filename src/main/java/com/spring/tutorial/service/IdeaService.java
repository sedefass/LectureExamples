package com.spring.tutorial.service;

import com.spring.tutorial.model.IdeaDto;

interface IdeaService {
    IdeaDto create(IdeaDto ideaDto);

    IdeaDto getById(Long id);
}


