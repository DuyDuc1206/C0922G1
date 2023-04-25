package com.example.be.controller;

import com.example.be.model.Course;
import com.example.be.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> courseList = courseService.findAll();
        if (courseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String name) {
        List<Course> courseList = courseService.findCourse(name);
        if (courseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

}
