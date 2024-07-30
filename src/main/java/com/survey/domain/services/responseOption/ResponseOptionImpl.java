package com.survey.domain.services.responseOption;

import com.survey.domain.repository.ResponseOptionRepository;
import com.survey.persistence.entities.ResponsOption;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ResponseOptionImpl implements IResponseOption{
    @Autowired
    private ResponseOptionRepository repository;

    @Override
    public List<ResponsOption> findAll() {
        return (List<ResponsOption>) repository.findAll();
    }

    @Override
    public Optional<ResponsOption> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponsOption save(ResponsOption responsOption) {
        return repository.save(responsOption);
    }

    @Override
    public Optional<ResponsOption> update(Long id, ResponsOption responsOption) {
        Optional<ResponsOption> getResponsOption = repository.findById(id);
        if (getResponsOption.isPresent()){
            ResponsOption newResponsOption = getResponsOption.orElseThrow();
            newResponsOption.setOptionValue(responsOption.getOptionValue());
            newResponsOption.setCommentResponse(responsOption.getCommentResponse());
            newResponsOption.setOptionText(responsOption.getOptionText());
            newResponsOption.setQuestionParent(responsOption.getQuestionParent());
            newResponsOption.setQuestion(responsOption.getQuestion());
            return Optional.of(repository.save(newResponsOption));
        }
        return getResponsOption;
    }

    @Override
    public Optional<ResponsOption> delete(Long id) {
        Optional<ResponsOption> getResponsOption = repository.findById(id);
        getResponsOption.ifPresent(responsOption -> {
            repository.delete(responsOption);
        });
        return getResponsOption;
    }
}
