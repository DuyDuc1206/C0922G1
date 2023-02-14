package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showProductList(Model model,
                                        @SessionAttribute(value = "cart", required = false) CartDto cart,
                                        @CookieValue(value = "productId", required = false, defaultValue = "-1") Integer id) {
        model.addAttribute("historyProduct", productService.findById(id));
        if (cart != null) {
            model.addAttribute("cart", cart);
        }
        return new ModelAndView("/product/list", "productList", productService.findAll());
    }

    @GetMapping("/product/detail/{id}")
    public String detailProduct(@PathVariable("id") Integer id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id));
        return "/product/detail";
    }

    @GetMapping("/shop/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, @SessionAttribute(value = "cart") CartDto cart) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
