package com.survey.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "response_catalogs")
public class ResponseCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "response_option")
    private Integer responseOption;
    @Column(name = "response_text")
    private String responseText;

    @ManyToOne
    private Catalog catalog;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Response response;

    public ResponseCatalog() {
    }

    public ResponseCatalog(Integer responseOption, String responseText) {
        this.responseOption = responseOption;
        this.responseText = responseText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(Integer responseOption) {
        this.responseOption = responseOption;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
