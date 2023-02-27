package com.example.test.dto;

import com.example.test.model.QuestionType;
import com.example.test.model.Status;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionContentDto implements Validator {
    private Integer id;
    @NotEmpty(message = "Tiêu đề không được để trống")
    @Size(min = 5, max = 100, message = "tiêu đề từ 5 đến 100 kí tự")
    private String tittle;
    @NotEmpty(message = "Nội dung không được để trống")
    @Size(min = 5, max = 500, message = "Nội dung từ 5 đến 500 kí tự")
    private String content;
    private String answer;
    private String dateCreate;
    private QuestionType questionType;
    private Status status;

    public QuestionContentDto() {
    }

    public QuestionContentDto(Integer id, String tittle, String content, String answer, String dateCreate, QuestionType questionType, Status status) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
