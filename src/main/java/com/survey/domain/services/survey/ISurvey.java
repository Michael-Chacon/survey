package com.survey.domain.services.survey;

import com.survey.persistence.entities.Survey;

import java.util.List;
import java.util.Optional;

public interface ISurvey {
    List<Survey> findAll();
    Optional<Survey> findById(Long id);
    Survey save(Survey survey);
    Optional<Survey> update(Long id, Survey survey);
    Optional<Survey> delete(Long id);
}
