package com.example.test.repository;

import com.example.test.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    @Query(value = "select * from question_content where flag_delete = false and tittle like concat('%',:name,'%') and question_type_id =  ")
    Page<QuestionContent> findAll(String name, Integer questionTypeId, Pageable pageable);
}
