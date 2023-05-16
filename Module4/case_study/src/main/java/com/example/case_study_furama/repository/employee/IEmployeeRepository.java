package com.example.case_study_furama.repository.employee;

import com.example.case_study_furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee  where is_delete = false and name like concat('%',:name,'%') and " +
            "position_id like concat('%',:positionId,'%') and education_degree_id like concat('%',:degreeId,'%') ",nativeQuery = true)
    Page<Employee> searchAndDisplay(@Param("name") String name, @Param("positionId") String positionId, @Param("degreeId") String degreeId, Pageable pageable);

    @Modifying
    @Query(value = "update employee set is_delete = true where id = :id",nativeQuery = true)
    void deleteEmployee(@Param("id")Integer id);
}
