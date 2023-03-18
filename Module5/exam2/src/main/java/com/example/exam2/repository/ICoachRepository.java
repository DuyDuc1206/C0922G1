package com.example.exam2.repository;

import com.example.exam2.model.Coach;
import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer> {
    @Query(value = "select * from coach as c join company_name as cp on cp.id = c.company_name_id " +
            "join position as p on p.id = c.start_location_id" +
            "join position on p.id = c.destination_id" +
            "join type_coach as tc on tc.id = c.type_coach_id",
            nativeQuery = true)
    Page<Coach> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "delete from coach where id=:id", nativeQuery = true)
    void remove(@Param("id") Integer id);

//    @Transactional
//    @Modifying
//    @Query(value = "select * from coach where id = :id",nativeQuery = true)
//    void findById(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "update coach set email = :email, phone_number = :phoneNumber, start_time = :startTime, end_time = :endTime, company_name_id = :idCp," +
            "destination_id = :idDes,start_location_id = :idSl, type_coach_id = :idTc where id = :id",
            nativeQuery = true)
    void edit( @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("startTime") String startTime,
              @Param("endTime") String endTime, @Param("idCp") CompanyName companyName,@Param("idSl") Position destination, @Param("idDes") Position startLocation,
              @Param("idTc") TypeCoach typeCoach,@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into coach(id, code_coach, email, end_time, phone_number, start_time,company_name_id,destination_id,start_location_id,type_coach_id) values (:id, :codeCoach, :email, :endTime, :phoneNumber," +
            " :startTime,:companyNameId,:destinationId, :startLocationId, :typeCoachId)",
            nativeQuery = true)
    void create(@Param("id") Integer id, @Param("codeCoach") Integer codeCoach, @Param("email") String email, @Param("endTime") String endTime, @Param("phoneNumber") String phoneNumber, @Param("startTime") String startTime,
                @Param("companyNameId") CompanyName companyName, @Param("destinationId") Position destination, @Param("startLocationId") Position startLocation, @Param("typeCoachId") TypeCoach typeCoach);
}
