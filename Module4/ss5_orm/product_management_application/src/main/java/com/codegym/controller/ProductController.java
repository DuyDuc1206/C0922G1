package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirects) {
        productService.create(product);
        redirects.addFlashAttribute("mess", "Add Successfully");
        return "redirect:/product";
    }

    @PostMapping("remove")
    public String removeProduct(int id, RedirectAttributes attributes) {
        productService.remove(id);
        attributes.addFlashAttribute("mess", "Delete Successfully");
        return "redirect:/product";
    }

    @GetMapping("view")
    public String view(int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("search")
    public String searchProduct(String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        return "list";
    }

    @GetMapping("edit-form")
    public String showFormEdit(int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("mess","Edit Successfully");
        return "redirect:/product";
    }
}
