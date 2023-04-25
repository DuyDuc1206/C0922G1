package com.example.be.service;

import com.example.be.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findAllLesson(Integer courseId);
}
