package com.example.be.controller;


import com.example.be.dto.IOrders;
import com.example.be.dto.IPurchaseHistory;
import com.example.be.dto.OrdersDTO;
import com.example.be.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/orders")
@RestController
@CrossOrigin("*")
public class OrdersController {
    @Autowired
    private IOrdersService orderService;

    @PostMapping("/add")
    private ResponseEntity<?> addCart(@RequestBody OrdersDTO ordersDTO) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = currentDateTime.format(formatter);

        orderService.addOrder(formattedDateTime,ordersDTO.getTotalPrice(),ordersDTO.getIdCart(),ordersDTO.getCodeOrder());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail-purchase")
    private ResponseEntity<?> detailPurchase(@RequestParam(defaultValue = "", required = false) String codeOrder) {
        List<IPurchaseHistory> purchaseHistories = orderService.detailPurchase(codeOrder);
        if (purchaseHistories.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<IPurchaseHistory>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(purchaseHistories, HttpStatus.OK);
    }

    @GetMapping("/list")
    private ResponseEntity<?> getAll(@RequestParam(defaultValue = "", required = false) Integer idUser) {
        List<IOrders> purchaseHistories = orderService.getAllOrder(idUser);
        if (purchaseHistories.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<IOrders>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(purchaseHistories, HttpStatus.OK);
    }

    @GetMapping("/limit")
    private ResponseEntity<?> getCodeOrderLimit() {
       IOrders codeOrderLimit = orderService.getCodeOrderLimit();
        if (codeOrderLimit == null) {
            return new ResponseEntity<>(new ArrayList<IOrders>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(codeOrderLimit, HttpStatus.OK);
    }

    @GetMapping("/date")
    private ResponseEntity<?> detailPurchase(@RequestParam(defaultValue = "", required = false) int idCourse,
                                             @RequestParam(defaultValue = "", required = false) int idUser) {
        IPurchaseHistory purchaseHistories = orderService.getDateCourseBuy(idCourse,idUser);
        if (purchaseHistories == null) {
            return new ResponseEntity<>(purchaseHistories, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(purchaseHistories, HttpStatus.OK);
    }
}
