package com.example.case_study_furama.controller;

import com.example.case_study_furama.service.customer.ICustomerService;
import com.example.case_study_furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showCustomerList(Model model, @RequestParam(required = false, defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "") String email,
                                   @RequestParam(required = false, defaultValue = "") String id,
                                   @PageableDefault(size = 5, page = 0) Pageable pageable) {
        model.addAttribute("customerPage", customerService.getAllCustomer(name, email, id, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        model.addAttribute("searchName", name);
        model.addAttribute("searchGender", email);
        model.addAttribute("searchCustomerType", id);
        return "/customer/list";
    }
}
