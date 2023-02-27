package com.example.test.model;

import javax.persistence.*;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tittle;
    private String content;
    private String answer;
    private String dateCreate;
    @ManyToOne
    private QuestionType questionType;
    @ManyToOne
    private Status status;
    @Column(columnDefinition = "bit default false")
    private boolean flagDelete;

    public QuestionContent() {
    }

    public QuestionContent(Integer id, String tittle, String content, String answer, String dateCreate, QuestionType questionType,Status status) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.questionType = questionType;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
