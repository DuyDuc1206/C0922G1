package com.example.be.repository;

import com.example.be.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByCourseName(String name);

    List<Course> findAll();

    @Query(value = "SELECT * FROM course WHERE id_course = :idCourse", nativeQuery = true)
    Optional<Course> findCourseById(@Param("idCourse") Integer idCourse);

    @Query(value = "SELECT * FROM course WHERE course.course_name like concat('%':nameSearch:'%') ", nativeQuery = true)
    Page<Course> getAllCourse(Pageable pageable, @Param("nameSearch") String nameSearch);
}
