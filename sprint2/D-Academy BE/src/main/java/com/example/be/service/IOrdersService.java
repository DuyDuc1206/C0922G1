package com.example.be.service;

import com.example.be.dto.IOrders;
import com.example.be.dto.IPurchaseHistory;

import java.util.List;

public interface IOrdersService {
    void addOrder(String orderDate,double totalPrice,Integer idCart,String codeOrder);

    List<IPurchaseHistory> detailPurchase(String codeOrder);
    IPurchaseHistory getDateCourseBuy(int idCourse,int idUser);

    List<IOrders> getAllOrder(Integer idUser);
    IOrders getCodeOrderLimit();
}
