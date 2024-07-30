package com.survey.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalogs")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalog")
    private List<ResponseCatalog> responseCatalogs;

    public Catalog() {
        this.responseCatalogs = new ArrayList<>();
    }

    public Catalog(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResponseCatalog> getResponseCatalogs() {
        return responseCatalogs;
    }

    public void setResponseCatalogs(List<ResponseCatalog> responseCatalogs) {
        this.responseCatalogs = responseCatalogs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
