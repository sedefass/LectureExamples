package com.spring.tutorial.repository;

import com.spring.tutorial.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.title LIKE %:searchWord% OR e.description LIKE %:searchWord% ORDER BY e.startDate")
    List<Event> findEventsBySearchWord(@Param("searchWord") String word);

    @Query("SELECT e FROM Event e WHERE e.startDate > :date ORDER BY e.startDate")
    List<Event> findEventsBySearchDate(@Param("date") Instant date);

}
