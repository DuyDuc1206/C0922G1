package com.example.be.repository;

import com.example.be.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Integer> {
    @Query(value = "select l.id_lesson , l.lesson_content, l.lesson_name, c.id_course from lesson as l " +
            "join course as c on c.id_course = l.id_course where c.id_course = :idCourse", nativeQuery = true)
    List<Lesson> findLessonByCourse(@Param("idCourse") Integer idCourse);

    List<Lesson> findAll();

   Optional<Lesson> findLessonByIdLesson(Integer id);
}
