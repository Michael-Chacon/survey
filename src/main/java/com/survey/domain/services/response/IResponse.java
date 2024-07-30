package com.survey.domain.services.response;

import com.survey.persistence.entities.Response;

import java.util.List;
import java.util.Optional;

public interface IResponse {
    List<Response> findAll();
    Optional<Response> findById(Long id);
    Response save(Response response);
    Optional<Response> update(Long id, Response response);
    Optional<Response> delete(Long id);
}
