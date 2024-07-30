package com.survey.domain.services.question;

import com.survey.persistence.entities.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestion {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Question save(Question question);
    Optional<Question> update(Long id, Question question);
    Optional<Question> delete(Long id);
}
