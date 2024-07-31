package com.survey.domain.services.detailResponse;

import com.survey.domain.repository.DetailResponseRepository;
import com.survey.persistence.entities.DetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsResponseImpl implements IDetailResponse{
    @Autowired
    private DetailResponseRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<DetailResponse> findAll() {
        return (List<DetailResponse>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetailResponse> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetailResponse save(DetailResponse detailResponse) {
        return repository.save(detailResponse);
    }

    @Transactional
    @Override
    public Optional<DetailResponse> update(Long id, DetailResponse detailResponse) {
        Optional<DetailResponse> getDetailResponse = repository.findById(id);
        if (getDetailResponse.isPresent()){
            DetailResponse newDetailResponse = getDetailResponse.orElseThrow();
            newDetailResponse.setResponse(detailResponse.getResponse());
            newDetailResponse.setResponseOption(detailResponse.getResponseOption());
            newDetailResponse.setResponseText(detailResponse.getResponseText());
            newDetailResponse.setQuestion(detailResponse.getQuestion());
            return Optional.of(repository.save(newDetailResponse));
        }
        return getDetailResponse;
    }

    @Transactional
    @Override
    public Optional<DetailResponse> delete(Long id) {
        Optional<DetailResponse> getDetailResponse = repository.findById(id);
        getDetailResponse.ifPresent(detailResponse -> {
            repository.delete(detailResponse);
        });
        return getDetailResponse;
    }
}
