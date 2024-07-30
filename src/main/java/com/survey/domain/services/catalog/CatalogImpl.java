package com.survey.domain.services.catalog;

import com.survey.domain.repository.CatalogRepository;
import com.survey.persistence.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CatalogImpl implements ICatalog{

    @Autowired
    private CatalogRepository repository;

    @Override
    public List<Catalog> findAll() {
        return (List<Catalog>) repository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return repository.save(catalog);
    }

    @Override
    public Optional<Catalog> update(Long id, Catalog catalog) {
        Optional<Catalog> getCatalog = repository.findById(id);
        if (getCatalog.isPresent()){
            Catalog newCatalog = getCatalog.orElseThrow();
            newCatalog.setName(catalog.getName());
            newCatalog.setResponseCatalogs(catalog.getResponseCatalogs());
            return Optional.of(repository.save(newCatalog));
        }
        return getCatalog;
    }

    @Override
    public Optional<Catalog> delete(Long id) {
        Optional<Catalog> getCatalog = repository.findById(id);
        getCatalog.ifPresent(catalog -> {
            repository.delete(catalog);
        });
        return getCatalog;
    }

}
