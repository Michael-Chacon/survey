package com.survey.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "response_options")
public class ResponsOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "option_value")
    private String optionValue;
    @Column(name = "comment_response")
    private String commentResponse;
    @Column(name = "option_text")
    private String optionText;
    @Column(name = "question_parent")
    private Integer questionParent;

    @ManyToOne
    private Question question;

    public ResponsOption() {
    }

    public ResponsOption(String optionValue, String commentResponse, String optionText, Integer questionParent) {
        this.optionValue = optionValue;
        this.commentResponse = commentResponse;
        this.optionText = optionText;
        this.questionParent = questionParent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(String commentResponse) {
        this.commentResponse = commentResponse;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Integer getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(Integer questionParent) {
        this.questionParent = questionParent;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ResponsOption{" +
                "id=" + id +
                ", optionValue='" + optionValue + '\'' +
                ", commentResponse='" + commentResponse + '\'' +
                ", optionText='" + optionText + '\'' +
                ", questionParent=" + questionParent +
                '}';
    }
}
