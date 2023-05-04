package com.example.be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_course",referencedColumnName = "id_course")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;
    private Integer quantity;
    @Column(columnDefinition = "bit default false")
    private Boolean flagDelete;
}
