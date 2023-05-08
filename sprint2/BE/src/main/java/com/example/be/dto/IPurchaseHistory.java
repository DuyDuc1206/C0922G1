package com.example.be.dto;

public interface IPurchaseHistory {
    Integer getIdOrder();
    String getCodeOrder();
    String getCourseName();
    String getThumbnail();
    double getTotalPrice();
    Integer getQuantity();
    String getOrderDate();
}
