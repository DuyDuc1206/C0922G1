package com.example.test2.repository;

import com.example.test2.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IPigRepository extends JpaRepository<Pig,Integer> {
    @Query(value = "select * from pig where pig.code_pig like concat('%',:codePig,'%') " +
            "and pig.status like concat('%',:stt,'%') and pig.origin_id like concat('%',:origin,'%') ",nativeQuery = true)
    Page<Pig> findAll(@Param("codePig") String codePig,@Param("stt") String stt,@Param("origin") String origin, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update pig set pig.status = 'Da Ban' where pig.id = :id",nativeQuery = true)
    void edit(@Param("id") Integer id);
}
