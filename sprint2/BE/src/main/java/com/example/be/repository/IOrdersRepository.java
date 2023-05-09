package com.example.be.repository;

import com.example.be.dto.IOrders;
import com.example.be.dto.IPurchaseHistory;
import com.example.be.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into  orders (order_date, total_price, id_cart, code_order)\n" +
            "values (:orderDate, :totalPrice, :idCart, :codeOrder)", nativeQuery = true)
    void addOrder(@Param("orderDate") String orderDate,
                  @Param("totalPrice") double totalPrice,
                  @Param("idCart") Integer idCart,
                  @Param("codeOrder") String codeOrder);

    @Query(value = "select sum(o.total_price) as totalPrice,\n" +
            "       o.order_date as orderDate,\n" +
            "       o.id_order as idOrder,\n" +
            "       o.code_order as codeOrder\n" +
            "from orders as o\n" +
            "         join cart as c on o.id_cart = c.id\n" +
            "         join user as u on c.id_user = u.id\n" +
            "where id_user = :idUser\n" +
            "group by o.code_order\n" +
            "order by o.id_order desc", nativeQuery = true)
    List<IOrders> getAllOrder(@Param("idUser") Integer idUser);

    @Query(value = "select cs.course_name as courseName, cs.thumbnail as thumbnail, o.total_price as totalPrice,\n" +
            "       o.id_order as idOrder, o.code_order as codeOrder, c.quantity as quantity,\n" +
            "       o.order_date as orderDate\n" +
            "from orders as o\n" +
            "             join cart as c on c.id = o.id_cart\n" +
            "             join user as u on u.id = c.id_user\n" +
            "             join course as cs on cs.id_course = c.id_course\n" +
            "            where o.code_order = :codeOder", nativeQuery = true)
    List<IPurchaseHistory> detailPurchase(@Param("codeOder") String codeOder);
}
