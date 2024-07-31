package com.survey.web.controllers;

import com.survey.domain.services.catalog.ICatalog;
import com.survey.persistence.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {

    @Autowired
    private ICatalog service;

    @GetMapping
    public List<Catalog> listCatalog(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> view(@PathVariable Long id){
        Optional<Catalog> getCatalog = service.findById(id);
        if (getCatalog.isPresent()){
            return ResponseEntity.ok(getCatalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Catalog> save(@RequestBody Catalog catalog){
        Catalog data = service.save(catalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalog> update(@PathVariable Long id, @RequestBody Catalog catalog){
        Optional<Catalog> data = service.update(id, catalog);
        if (data.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Catalog> delete(@PathVariable Long id){
        Optional<Catalog> catalog = service.delete(id);
        if (catalog.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(catalog.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
