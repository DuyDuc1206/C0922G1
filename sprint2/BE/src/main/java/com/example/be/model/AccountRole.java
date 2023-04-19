package com.example.be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountRoleId;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Account account;
}
