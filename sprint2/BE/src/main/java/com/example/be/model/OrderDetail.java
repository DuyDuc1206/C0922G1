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
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "payment_id",referencedColumnName = "payment_id")
    private Payment payment;
}
