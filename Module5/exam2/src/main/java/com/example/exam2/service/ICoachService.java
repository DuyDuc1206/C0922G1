package com.example.exam2.service;

import com.example.exam2.model.Coach;
import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoachService {

    void removeCoach(Integer id);

    void createCoach(Coach coach);

    Coach findById(Integer id);

    void editCoach(String email, String phoneNumber,String startTime, String endTime,CompanyName companyName, Position destination, Position startLocation,
                   TypeCoach typeCoach, Integer id);
    Page<Coach> findAll(Pageable pageable);
}
