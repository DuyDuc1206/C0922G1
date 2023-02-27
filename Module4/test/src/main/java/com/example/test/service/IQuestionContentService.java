package com.example.test.service;

import com.example.test.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {

    Page<QuestionContent> findAll(String name, String questionTypeId, Pageable pageable);
    Page<QuestionContent> findQuestion(Pageable pageable);
    void remove(Integer id);
    void saveQuestion(QuestionContent questionContent);
}
