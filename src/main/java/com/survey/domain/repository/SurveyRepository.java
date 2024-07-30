package com.survey.domain.repository;

import com.survey.persistence.entities.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
    @Query("select s from Survey s left join fetch s.responses left join fetch s.chapters where s.id = ?1")
    Optional<Survey> findOne(Long id);
}
