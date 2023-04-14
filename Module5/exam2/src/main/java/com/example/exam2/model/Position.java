package com.example.exam2.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "startLocation")
    @JsonBackReference(value="sta")
    private Set<Coach> coachSet1;

    @OneToMany(mappedBy = "destination")
    @JsonBackReference(value="des")
    private Set<Coach> coachSet2;

}
