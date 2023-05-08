package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer idOrder;
    private String codeOrder;
    private String orderDate;
    private double totalPrice;
    @Column(columnDefinition = "bit default false")
    private Boolean flagDelete;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_cart",referencedColumnName = "id")
    private Cart cart;
}
