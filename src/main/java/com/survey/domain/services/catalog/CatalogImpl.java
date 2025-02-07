package com.survey.domain.services.catalog;

import com.survey.domain.repository.CatalogRepository;
import com.survey.persistence.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogImpl implements ICatalog{

    @Autowired
    private CatalogRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Catalog> findAll() {
        return (List<Catalog>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Catalog> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Catalog save(Catalog catalog) {
        return repository.save(catalog);
    }

    @Transactional
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

    @Transactional
    @Override
    public Optional<Catalog> delete(Long id) {
        Optional<Catalog> getCatalog = repository.findById(id);
        getCatalog.ifPresent(catalog -> {
            repository.delete(catalog);
        });
        return getCatalog;
    }

}
