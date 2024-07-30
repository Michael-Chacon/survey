package com.survey.persistence.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_number")
    private String questionNumber;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "question_type")
    private String questionType;
    @Column(name = "comment_question")
    private String commentQuestion;
    @JoinColumn(name = "question_parent")
    private String questionParent;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentQuestion")
    private Set<Question> subQuestions;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    private Chapter chapter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<DetailResponse> detailResponses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<ResponseCatalog> responseCatalogs;

    public Question() {
        this.detailResponses = new HashSet<>();
    }

    public Question(String questionNumber, String questionText, String questionType, String commentQuestion) {
        this();
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.questionType = questionType;
        this.commentQuestion = commentQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getCommentQuestion() {
        return commentQuestion;
    }

    public void setCommentQuestion(String commentQuestion) {
        this.commentQuestion = commentQuestion;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(String questionParent) {
        this.questionParent = questionParent;
    }

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public Set<Question> getSubQuestions() {
        return subQuestions;
    }

    public void setSubQuestions(Set<Question> subQuestions) {
        this.subQuestions = subQuestions;
    }

    public Set<DetailResponse> getDetailResponses() {
        return detailResponses;
    }

    public void setDetailResponses(Set<DetailResponse> detailResponses) {
        this.detailResponses = detailResponses;
    }

    public Set<ResponseCatalog> getResponseCatalogs() {
        return responseCatalogs;
    }

    public void setResponseCatalogs(Set<ResponseCatalog> responseCatalogs) {
        this.responseCatalogs = responseCatalogs;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionNumber='" + questionNumber + '\'' +
                ", questionText='" + questionText + '\'' +
                ", questionType='" + questionType + '\'' +
                ", commentQuestion='" + commentQuestion + '\'' +
                '}';
    }
}
