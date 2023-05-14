package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer idCourse;
    private String courseName;
    @Lob
    private String courseDescription;
    private String thumbnail;
    private Double price;
//    private Integer enrolled;
    private Integer courseDuration;
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Lesson> lessonSet;
    @ManyToOne()
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;
}
