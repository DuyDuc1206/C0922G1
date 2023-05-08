package com.example.be.repository;

import com.example.be.dto.ICart;
import com.example.be.model.Cart;
import com.example.be.model.Course;
import com.example.be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> getAllByUser(User user);
    Cart findByCourseAndUser(Course course, User user);
    Boolean existsByCourseAndUser(Course course,User user);

    @Query(value = "select cs.id_course as courseId, cs.course_name as courseName, cs.thumbnail as thumbnail, cs.price as price,\n" +
            "       c.id as id, c.quantity as quantity\n" +
            "            from cart as c\n" +
            "                     join user as u on u.id = c.id_user\n" +
            "                     join course as cs on cs.id_course = c.id_course\n" +
            "            where c.flag_delete = false and c.id_user = :idUser",
            nativeQuery = true)
    List<ICart> getAllCartsByUserId(@Param("idUser") Integer idUser);

    @Modifying
    @Transactional
    @Query(value = "update cart set cart.flag_delete = true\n" +
            "            where cart.id_user = :idUser", nativeQuery = true)
    void setFlagDelete(@Param("idUser") Integer idUser);
}
