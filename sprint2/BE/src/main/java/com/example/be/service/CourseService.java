package com.example.be.service;

import com.example.be.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseService courseService;

    @Override
    public List<Course> findCourse(String name) {
        return null;
    }
}
