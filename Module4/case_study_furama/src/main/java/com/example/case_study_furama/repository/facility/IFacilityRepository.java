package com.example.case_study_furama.repository.facility;

import com.example.case_study_furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * from facility where ( facility.name like  concat('%',:name,'%') and facility.faciliy_type_id like concat('%',:id,'%') )",nativeQuery = true)
    Page<Facility> searchAndDisplay(@Param("name") String name, @Param("id") String id, Pageable pageable);
}
