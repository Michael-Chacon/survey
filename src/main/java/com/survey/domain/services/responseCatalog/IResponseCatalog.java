package com.survey.domain.services.responseCatalog;

import com.survey.persistence.entities.ResponseCatalog;

import java.util.List;
import java.util.Optional;

public interface IResponseCatalog {
    List<ResponseCatalog> findAll();
    Optional<ResponseCatalog> findById(Long id);
    ResponseCatalog save(ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> delete(Long id);}
