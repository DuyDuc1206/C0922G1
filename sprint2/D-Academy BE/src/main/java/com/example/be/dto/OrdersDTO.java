package com.example.be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    private  String codeOrder;
    private  double totalPrice;
    private  Integer idCart;
    private  Integer idCourse;
    private  Integer quantity;

}
