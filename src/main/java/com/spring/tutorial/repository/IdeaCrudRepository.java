package com.spring.tutorial.repository;

import com.spring.tutorial.domain.Idea;
import org.springframework.data.repository.CrudRepository;

interface IdeaCrudRepository extends CrudRepository<Idea, Long> {
}