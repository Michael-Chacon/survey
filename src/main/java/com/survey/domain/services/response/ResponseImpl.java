package com.survey.domain.services.response;

import com.survey.domain.repository.ResponseRepository;
import com.survey.persistence.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseImpl implements IResponse{
    @Autowired
    private ResponseRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Response> findAll() {
        return (List<Response>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Response> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Response save(Response response) {
        return repository.save(response);
    }

    @Transactional
    @Override
    public Optional<Response> update(Long id, Response response) {
        Optional<Response> getResponse = repository.findById(id);
        if (getResponse.isPresent()){
            Response newResponse = getResponse.orElseThrow();
            newResponse.setNameResponse(response.getNameResponse());
            newResponse.setResponseTime(response.getResponseTime());
            newResponse.setResponseDate(response.getResponseDate());
            newResponse.setDetailResponses(response.getDetailResponses());
            newResponse.setResponseCatalogs(response.getResponseCatalogs());
            newResponse.setSurvey(response.getSurvey());
            return Optional.of(repository.save(newResponse));
        }
        return getResponse;
    }

    @Transactional
    @Override
    public Optional<Response> delete(Long id) {
        Optional<Response> getResponse = repository.findById(id);
        getResponse.ifPresent(response -> {
            repository.delete(response);
        });
        return getResponse;
    }
}
