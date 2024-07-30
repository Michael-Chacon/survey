package com.survey.domain.services.survey;

import com.survey.domain.repository.SurveyRepository;
import com.survey.persistence.entities.Survey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SurveyImpl implements ISurvey{
    @Autowired
    private SurveyRepository repository;

    @Override
    public List<Survey> findAll() {
        return (List<Survey>) repository.findAll();
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    @Override
    public Optional<Survey> update(Long id, Survey survey) {
        Optional<Survey> getSurvey = repository.findById(id);
        if (getSurvey.isPresent()){
            Survey newSurvey = getSurvey.orElseThrow();
            newSurvey.setNama(survey.getNama());
            newSurvey.setDescription(survey.getDescription());
            newSurvey.setCreateAt(survey.getCreateAt());
            newSurvey.setUpdateAt(survey.getUpdateAt());
            newSurvey.setChapters(survey.getChapters());
            newSurvey.setResponses(survey.getResponses());
            return Optional.of(repository.save(newSurvey));
        }
        return getSurvey;
    }

    @Override
    public Optional<Survey> delete(Long id) {
        Optional<Survey> getSurvey = repository.findById(id);
        getSurvey.ifPresent(survey -> {
            repository.delete(survey);
        });
        return getSurvey;
    }
}
