package com.example.case_study_furama.repository.facility;

import com.example.case_study_furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * from facility where facility.is_delete = false and facility.name like  concat('%',:name,'%') and facility.facility_type_id like concat('%',:id,'%') ",
            countQuery = "select * from facility where facility.is_delete = false and facility.name like  concat('%',:name,'%') and facility.facility_type_id like concat('%',:id,'%') ",
            nativeQuery = true)
    Page<Facility> searchAndDisplay(@Param("name") String name, @Param("id") String id, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update facility set is_delete = true where facility.id = :id",nativeQuery = true)
    void remove(@Param("id") Integer id);
}
