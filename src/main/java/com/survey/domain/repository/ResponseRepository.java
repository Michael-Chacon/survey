package com.survey.domain.repository;

import com.survey.persistence.entities.Response;
import org.springframework.data.repository.CrudRepository;

public interface ResponseRepository extends CrudRepository<Response, Long> {
}
