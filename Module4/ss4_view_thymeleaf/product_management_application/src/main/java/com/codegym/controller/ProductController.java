package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "product/list";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String saveProduct(Product product) {
        product.setId((int) (Math.random() * 100));
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/edit-form")
    public String editProduct(int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String updateProduct( Product product, int id) {
        productService.update(id, product);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(int id){
        productService.remove(id);
        return "redirect:/product";
    }

    @GetMapping("view")
    public String view(int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }
}
