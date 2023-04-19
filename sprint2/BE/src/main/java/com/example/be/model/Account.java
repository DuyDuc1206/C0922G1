package com.example.be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String username;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;
    private String email;
    private String encrypt_password;
    private String avatar;
    @Column(columnDefinition = "bit default 1")
    private boolean flagUser;
}
