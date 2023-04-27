package com.example.be.service;

import com.example.be.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findLessonByIdCourse(Integer courseId);
    List<Lesson> findAll();

    Lesson findLessonById(Integer idLesson);
}
