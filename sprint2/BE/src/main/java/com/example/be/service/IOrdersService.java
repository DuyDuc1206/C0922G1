package com.example.be.service;

import com.example.be.dto.IOrders;
import com.example.be.dto.IPurchaseHistory;

import java.util.List;

public interface IOrdersService {
    void addOrder(String orderDate,double totalPrice,Integer idCart,String codeOrder);

    List<IPurchaseHistory> detailPurchase(String codeOrder);

    List<IOrders> getAllOrder(Integer idUser);
}
