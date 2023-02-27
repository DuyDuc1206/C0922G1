package com.example.test.service;

import com.example.test.model.QuestionContent;
import com.example.test.repository.IQuestionContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService{
    @Autowired
    private IQuestionContentRepository questionContentRepository;
    @Override
    public Page<QuestionContent> findAll(String name, Integer questionTypeId, Pageable pageable) {
        return null;
    }
}
