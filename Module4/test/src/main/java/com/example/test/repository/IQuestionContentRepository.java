package com.example.test.repository;

import com.example.test.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    @Query(value = "select * from question_content where flag_delete = false and tittle like concat('%',:name,'%') " +
            "and question_type_id like concat('%',:questionTypeId,'%')",nativeQuery = true)
    Page<QuestionContent> findAll(@Param("name") String name,@Param("questionTypeId") String questionTypeId, Pageable pageable);

    @Modifying
    @Query(value = "update question_content set flag_delete = true where id = :id",nativeQuery = true)
    void remove(@Param("id") Integer id);
}
