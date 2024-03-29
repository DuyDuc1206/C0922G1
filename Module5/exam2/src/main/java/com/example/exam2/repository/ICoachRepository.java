package com.example.exam2.repository;

import com.example.exam2.dto.CoachListDto;
import com.example.exam2.model.Coach;
import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICoachRepository extends JpaRepository<Coach, Integer> {
    @Query(value = "select c.id, c.code, c.email, c.end_time as endTime, c.phone_number as phoneNumber, " +
            "c.start_time as startTime, cp.name as companyName, dt.name as destination, st.name as startLocation, tc.name as typeCoach " +
            "from coach as c " +
            "join company_name as cp on cp.id = c.company_name_id " +
            "join position as st on st.id = c.start_location_id " +
            "join position as dt on dt.id = c.destination_id " +
            "join type_coach as tc on tc.id = c.type_coach_id " +
            "where code like concat('%',:code,'%') and tc.name like concat('%',:typeCoach,'%')",
            countQuery = "select c.id, c.code, c.email, c.end_time as endTime, c.phone_number as phoneNumber, " +
                    "c.start_time as startTime, cp.name as companyName, dt.name as destination, st.name as startLocation, tc.name as typeCoach " +
                    "from coach as c " +
                    "join company_name as cp on cp.id = c.company_name_id " +
                    "join position as st on st.id = c.start_location_id " +
                    "join position as dt on dt.id = c.destination_id " +
                    "join type_coach as tc on tc.id = c.type_coach_id " +
                    "where code like concat('%',:code,'%') and tc.name like concat('%',:typeCoach,'%') ",
            nativeQuery = true)
    Page<CoachListDto> getAllCoach(Pageable pageable, @Param("code") String code,@Param("typeCoach") String typeCoach);

    @Query(value = "select * from coach where id = :id", nativeQuery = true)
    Coach getById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from coach where id=:id", nativeQuery = true)
    void remove(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "update coach set code = :code, email = :email, phone_number = :phoneNumber, start_time = :startTime, end_time = :endTime, company_name_id = :companyName," +
            "destination_id = :destination,start_location_id = :startLocation, type_coach_id = :typeCoach where id = :id",
            nativeQuery = true)
    void edit(@Param("code") String code, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("startTime") String startTime,
              @Param("endTime") String endTime, @Param("companyName") CompanyName companyName, @Param("destination") Position destination, @Param("startLocation") Position startLocation,
              @Param("typeCoach") TypeCoach typeCoach, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into coach(id, code, email, end_time, phone_number, start_time,company_name_id,destination_id,start_location_id,type_coach_id) values (:id, :code, :email, :endTime, :phoneNumber," +
            " :startTime,:companyNameId,:destinationId, :startLocationId, :typeCoachId)",
            nativeQuery = true)
    void create(@Param("id") Integer id, @Param("code") String code, @Param("email") String email, @Param("endTime") String endTime, @Param("phoneNumber") String phoneNumber, @Param("startTime") String startTime,
                @Param("companyNameId") CompanyName companyName, @Param("destinationId") Position destination, @Param("startLocationId") Position startLocation, @Param("typeCoachId") TypeCoach typeCoach);
}
