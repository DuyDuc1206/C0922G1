package com.example.be.service.impl;

import com.example.be.model.Course;
import com.example.be.repository.ICourseRepository;
import com.example.be.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Page<Course> getAllCourse(Pageable pageable, String nameSearch) {
        return courseRepository.getAllCourse(pageable,nameSearch);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

//    @Override
//    public Page<Course> getAll(Pageable pageable, String courseName, Integer idCourse) {
//        return courseRepository.getAllCourseByCategoryOrName(pageable,idCourse,courseName);
//    }

    @Override
    public Course findCourseById(Integer idCourse) {
        return courseRepository.findCourseById(idCourse).orElse(null);
    }
}
