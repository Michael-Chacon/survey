package com.survey.domain.services.catalog;

import com.survey.persistence.entities.Catalog;

import java.util.List;
import java.util.Optional;

public interface ICatalog {
    List<Catalog> findAll();
    Optional<Catalog> findById(Long id);
    Catalog save(Catalog catalog);
    Optional<Catalog> update(Long id, Catalog catalog);
    Optional<Catalog> delete(Long id);
}
