package com.example.exam2.service;

import com.example.exam2.model.Coach;

import java.util.List;

public interface ICoachService {
//    Page<Coach> findAll(Pageable pageable);

    void removeCoach(Integer id);

    void create(Coach coach);

    Coach findById(Integer id);

    void editCoach(Coach coach, Integer idCoach);
    List<Coach> findAllCoach();
}
