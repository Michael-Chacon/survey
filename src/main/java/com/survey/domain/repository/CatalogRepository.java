package com.survey.domain.repository;

import com.survey.persistence.entities.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}
