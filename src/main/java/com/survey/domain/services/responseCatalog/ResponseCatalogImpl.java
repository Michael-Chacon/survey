package com.survey.domain.services.responseCatalog;

import com.survey.domain.repository.ResponseCatalogRepository;
import com.survey.persistence.entities.ResponseCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseCatalogImpl implements IResponseCatalog{
    @Autowired
    private ResponseCatalogRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseCatalog> findAll() {
        return (List<ResponseCatalog>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResponseCatalog> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ResponseCatalog save(ResponseCatalog responseCatalog) {
        return repository.save(responseCatalog);
    }

    @Transactional
    @Override
    public Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog) {
        Optional<ResponseCatalog> getResponseCatalog = repository.findById(id);
        if (getResponseCatalog.isPresent()){
            ResponseCatalog newResponseCatalog = getResponseCatalog.orElseThrow();
            newResponseCatalog.setResponseOption(responseCatalog.getResponseOption());
            newResponseCatalog.setResponseText(responseCatalog.getResponseText());
            newResponseCatalog.setCatalog(responseCatalog.getCatalog());
            newResponseCatalog.setQuestion(responseCatalog.getQuestion());
            newResponseCatalog.setResponse(responseCatalog.getResponse());
            return Optional.of(repository.save(newResponseCatalog));
        }
        return getResponseCatalog;
    }

    @Transactional
    @Override
    public Optional<ResponseCatalog> delete(Long id) {
        Optional<ResponseCatalog> getResponseCatalog = repository.findById(id);
        getResponseCatalog.ifPresent(responseCatalog -> {
            repository.delete(responseCatalog);
        });
        return getResponseCatalog;
    }
}
