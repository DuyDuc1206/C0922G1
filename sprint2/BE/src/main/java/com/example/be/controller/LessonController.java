package com.example.be.controller;

import com.example.be.model.Lesson;
import com.example.be.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/lessons")
@RestController
@CrossOrigin("*")
public class LessonController {
    @Autowired
    private ILessonService lessonService;

    @GetMapping("")
    public ResponseEntity<List<Lesson>> getAllLesson() {
        List<Lesson> lessonList = lessonService.findAll();
        if (lessonList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lessonList, HttpStatus.OK);
    }


}
