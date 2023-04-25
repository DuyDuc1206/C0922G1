package com.example.be.repository;

import com.example.be.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILessonRepository extends JpaRepository<Lesson,Integer> {
    List<Lesson> findLessonByCourse(Integer courseId );
}
