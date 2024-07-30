package com.survey.domain.repository;

import com.survey.persistence.entities.ResponseCatalog;
import org.springframework.data.repository.CrudRepository;

public interface ResponseCatalogRepository extends CrudRepository<ResponseCatalog, Long> {
}
