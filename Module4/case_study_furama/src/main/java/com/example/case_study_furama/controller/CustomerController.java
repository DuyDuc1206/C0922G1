package com.example.case_study_furama.controller;

import com.example.case_study_furama.dto.CustomerDto;
import com.example.case_study_furama.model.customer.Customer;
import com.example.case_study_furama.service.customer.ICustomerService;
import com.example.case_study_furama.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                                   @RequestParam(required = false, defaultValue = "") String customerId,
                                   @PageableDefault(size = 5, page = 0) Pageable pageable) {
        model.addAttribute("customerPage", customerService.search(name, email, customerId, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("searchName", name);
        model.addAttribute("searchEmail", email);
        model.addAttribute("searchCustomerType", customerId);
        return "/customer/list";
    }

    @PostMapping("/add")
    public String createCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect,@PageableDefault(size = 5, page = 0) Pageable pageable){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("addModalFalse",true);
            model.addAttribute("mess",1);
            model.addAttribute("customerPage",customerService.findAll(pageable));
            model.addAttribute("customerTypeList",customerTypeService.findAllCustomerType());
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.saveCustomer(customer);
        redirect.addFlashAttribute("message", "Add Successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@ModelAttribute("idDelete") Integer id,RedirectAttributes redirect){
        customerService.remove(id);
        redirect.addFlashAttribute("message","Deleted Successfully!");
        return "redirect:/customer";
    }
}
