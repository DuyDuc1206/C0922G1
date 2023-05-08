package com.example.be.controller;

import com.example.be.dto.ICart;
import com.example.be.model.Cart;
import com.example.be.model.User;
import com.example.be.service.ICartService;
import com.example.be.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<List<ICart>> getAllCartByUser(@PathVariable("id") Integer id) {
        User user = userService.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
//        List<Cart> cartList = cartService.getAllByUser(user);
        List<ICart> cartList = cartService.findCartByUserId(id);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<?> addToCart(@RequestBody Cart cart) {
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    private ResponseEntity<?> deleteCart(@PathVariable("id") int id) {
        this.cartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/change/{operator}/{id}")
    private ResponseEntity<?> change(@PathVariable("operator") String operator, @PathVariable("id") int id) {
        Cart cart = cartService.findById(id);
        if (Objects.equals(operator, "-")) {
            System.out.println(operator);
            if (cart.getQuantity() == 1) {
                this.cartService.deleteById(id);
            } else {
                Cart cart2 = cartService.findById(id);
                cart2.setQuantity(cart2.getQuantity() - 1);
                cartService.save2(cart2);
            }
        } else {
            cart.setQuantity(cart.getQuantity() + 1);
            cartService.save2(cart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/flag-delete")
    private ResponseEntity<?> setFlagDelete(@RequestParam(defaultValue = "", required = false) Integer idUser) {
        cartService.setFlagDelete(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
