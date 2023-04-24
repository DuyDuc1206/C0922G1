package com.example.be.service;

import com.example.be.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findCourse(String name);
}
