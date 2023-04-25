package com.example.be.repository;

import com.example.be.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByCourseName(String name);
    List<Course> findAll();
}
