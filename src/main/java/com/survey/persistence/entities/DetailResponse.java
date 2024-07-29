package com.survey.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_responses")
public class DetailResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "response_option")
    private Integer responseOption;
    @Column(name = "response_text")
    private String responseText;

    @OneToOne
    private Question question;
    @OneToOne
    private Response response;

    public DetailResponse() {
    }

    public DetailResponse(Integer responseOption, String responseText) {
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

    @Override
    public String toString() {
        return "DetailResponse{" +
                "id=" + id +
                ", responseOption=" + responseOption +
                ", responseText='" + responseText + '\'' +
                ", question=" + question +
                ", response=" + response +
                '}';
    }
}
