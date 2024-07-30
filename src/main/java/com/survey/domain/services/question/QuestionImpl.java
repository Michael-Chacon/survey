package com.survey.domain.services.question;

import com.survey.domain.repository.QuestionRepository;
import com.survey.persistence.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionImpl implements  IQuestion{
    @Autowired
    private QuestionRepository repository;

    @Override
    public List<Question> findAll() {
        return (List<Question>) repository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return repository.save(question);
    }

    @Override
    public Optional<Question> update(Long id, Question question) {
        Optional<Question> getQuestion = repository.findById(id);
        if (getQuestion.isPresent()){
            Question newQuestion = getQuestion.orElseThrow();
            newQuestion.setQuestionNumber(question.getQuestionNumber());
            newQuestion.setQuestionText(question.getQuestionText());
            newQuestion.setQuestionType(question.getQuestionType());
            newQuestion.setCommentQuestion(question.getCommentQuestion());
            newQuestion.setQuestionParent(question.getQuestionParent());
            newQuestion.setSubQuestions(question.getSubQuestions());
            newQuestion.setSurvey(question.getSurvey());
            newQuestion.setChapter(question.getChapter());
            newQuestion.setSurvey(question.getSurvey());
            newQuestion.setDetailResponses(question.getDetailResponses());
            newQuestion.setResponseCatalogs(question.getResponseCatalogs());
            return Optional.of(repository.save(newQuestion));
        }
        return getQuestion;
    }

    @Override
    public Optional<Question> delete(Long id) {
        Optional<Question> getQuestion = repository.findById(id);
        getQuestion.ifPresent(question -> {
            repository.delete(question);
        });
        return getQuestion;
    }
}
