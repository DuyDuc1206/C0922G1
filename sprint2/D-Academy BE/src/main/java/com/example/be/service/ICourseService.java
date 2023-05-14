package com.example.be.service;

import com.example.be.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICourseService {
   Page<Course> getAllCourse(Pageable pageable, String nameSearch);
    List<Course> findAll();
    Course findCourseById(Integer idCourse);
}
