package com.example.be.controller;

import com.example.be.model.Course;
import com.example.be.model.Lesson;
import com.example.be.service.ICourseService;
import com.example.be.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private ILessonService lessonService;

//    @GetMapping("")
//    public ResponseEntity<List<Course>> getAllCourse() {
//        List<Course> courseList = courseService.findAll();
//        if (courseList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(courseList, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<Page<Course>> getAllCourse(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size,
                                                           @RequestParam(defaultValue = "") String nameSearch) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> courseList = courseService.getAllCourse(pageable, nameSearch);
        if (courseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Integer id) {
        Course course = courseService.findCourseById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{courseId}/lessons")
    public ResponseEntity<List<Lesson>> getLessonByIdCourse(@PathVariable Integer courseId) {
        List<Lesson> lessonList = lessonService.findLessonByIdCourse(courseId);
        if (lessonList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lessonList, HttpStatus.OK);
    }

}
