package com.example.case_study_furama.repository.contract;

import com.example.case_study_furama.dto.AttachFacilityDto;
import com.example.case_study_furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {

    @Query(value = "select d.contract_id as contractId, att.name as name, att.cost as cost,att.status as status,att.unit as unit,d.quantity as quantity\n" +
            "    from `attach_facility` as att\n" +
            "    join `contract_detail` as d on att.id = d.attach_facility_id\n" +
            "    where d.contract_id = :id",nativeQuery = true)
    List<AttachFacilityDto> findAttachFacility(@Param("id") Integer id);
}
