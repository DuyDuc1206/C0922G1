package com.example.be.service.impl;

import com.example.be.dto.IOrders;
import com.example.be.dto.IPurchaseHistory;
import com.example.be.repository.IOrdersRepository;
import com.example.be.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {
    @Autowired
    private IOrdersRepository orderRepository;

    @Override
    public void addOrder(String orderDate, double totalPrice, Integer idCart, String codeOrder) {
        orderRepository.addOrder(orderDate,totalPrice,idCart,codeOrder);
    }

    @Override
    public List<IPurchaseHistory> detailPurchase(String codeOrder) {
        return orderRepository.detailPurchase(codeOrder);
    }

    @Override
    public IPurchaseHistory getDateCourseBuy(int idCourse, int idUser) {
        return orderRepository.getDateCourseBuy(idCourse,idUser);
    }

    @Override
    public List<IOrders> getAllOrder(Integer idUser) {
        return orderRepository.getAllOrder(idUser);
    }

    @Override
    public IOrders getCodeOrderLimit() {
        return orderRepository.getCodeOrderLimit();
    }
}
