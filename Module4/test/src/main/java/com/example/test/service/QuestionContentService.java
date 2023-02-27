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
    public Page<QuestionContent> findAll(String name, String questionTypeId, Pageable pageable) {
        return questionContentRepository.findAll(name,questionTypeId,pageable);
    }

    @Override
    public Page<QuestionContent> findQuestion(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
        questionContentRepository.remove(id);
    }

    @Override
    public void saveQuestion(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

}
