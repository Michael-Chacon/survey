package com.survey.domain.repository;

import com.survey.persistence.entities.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
}
