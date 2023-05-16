package com.example.case_study_furama.repository.contract;

import com.example.case_study_furama.dto.IContractDto;
import com.example.case_study_furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select c.id as contractId, f.name as facilityName, cu.name as customerName, c.start_date as startDate, c.end_date as endDate,deposit,\n" +
            "    (sum(ifnull(att.cost,0)*ifnull(de.quantity,0))+(f.cost)-deposit) as total \n" +
            "    from `contract` as c\n" +
            "    left join `facility` as f on c.facility_id = f.id \n" +
            "    left join `customer` as cu on c.customer_id = cu.id\n" +
            "    left join `contract_detail` as de on c.id = de.contract_id\n" +
            "    left join `attach_facility` as att on att.id = de.attach_facility_id\n" +
            "    group by c.id", nativeQuery = true)
    Page<IContractDto> getTotal(Pageable pageable);
}
