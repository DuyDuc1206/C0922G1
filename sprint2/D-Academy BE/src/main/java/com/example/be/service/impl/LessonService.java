package com.example.be.service.impl;

import com.example.be.model.Lesson;
import com.example.be.repository.ILessonRepository;
import com.example.be.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements ILessonService {
    @Autowired
    private ILessonRepository lessonRepository;
    @Override
    public List<Lesson> findLessonByIdCourse(Integer courseId) {
        return lessonRepository.findLessonByCourse(courseId);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findLessonById(Integer idLesson) {
        return lessonRepository.findLessonByIdLesson(idLesson).orElse(null);
    }
}
