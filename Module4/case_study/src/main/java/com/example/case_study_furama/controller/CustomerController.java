package com.example.case_study_furama.controller;

import com.example.case_study_furama.dto.CustomerDto;
import com.example.case_study_furama.model.customer.Customer;
import com.example.case_study_furama.service.customer.ICustomerService;
import com.example.case_study_furama.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String showCustomerList(Model model,
                                   @RequestParam(required = false, defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "") String email,
                                   @RequestParam(required = false, defaultValue = "") String customerId,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        model.addAttribute("customerPage", customerService.search(name, email, customerId, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        model.addAttribute("addCustomerDto",new CustomerDto());
        model.addAttribute("editCustomerDto",new CustomerDto());
        model.addAttribute("searchName", name);
        model.addAttribute("searchEmail", email);
        return "/customer/list";
    }

    @PostMapping("/add")
    public String createCustomer(@Validated @ModelAttribute("addCustomerDto") CustomerDto addCustomerDto, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        new CustomerDto().validate(addCustomerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess",1);
            model.addAttribute("addCustomerDto",addCustomerDto);
            model.addAttribute("customerPage", customerService.findAll(pageable));
            model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
            model.addAttribute("editCustomerDto",new CustomerDto());
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(addCustomerDto, customer);
        if (!customerService.saveCustomer(customer)){
            model.addAttribute("mess",1);
            bindingResult.rejectValue("email","email","Email cannot be duplicated");
            bindingResult.rejectValue("phoneNumber","phone number","phone number cannot be duplicated");
            bindingResult.rejectValue("idCard","id card","idCard cannot be duplicated");
            model.addAttribute("customerPage", customerService.findAll(pageable));
            model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
            return "/customer/list";
        }
       else {
            customerService.saveCustomer(customer);
            redirect.addFlashAttribute("message", "Add Successfully!");
            return "redirect:/customer";
        }
    }

    @PostMapping("/update")
    public String editCustomer(@Validated @ModelAttribute("editCustomerDto") CustomerDto editCustomerDto, BindingResult bindingResult,
                               Model model, RedirectAttributes redirect, @PageableDefault(page = 0,size = 5) Pageable pageable) {
        new CustomerDto().validate(editCustomerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("editCustomerDto",editCustomerDto);
            model.addAttribute("customerPage", customerService.findAll(pageable));
            model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
            model.addAttribute("mess2",true);
            model.addAttribute("addCustomer",new CustomerDto());
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(editCustomerDto, customer);
        customerService.saveCustomer(customer);
        redirect.addFlashAttribute("message", "Edit Successfully!");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("idDelete") Integer id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete Successfully!");
        return "redirect:/customer";
    }

//    @GetMapping("/edit")
//    public String showFormEdit(Integer id, Model model){
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customerService.findById(id),customerDto);
//        model.addAttribute("customerDto",customerDto);
//        model.addAttribute("customerTypeList",customerTypeService.findAllCustomerType());
//        return "/customer/edit";
//    }
//
//    @PostMapping("update")
//    public String editCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,BindingResult bindingResult,Model model,RedirectAttributes redirect){
//        new CustomerDto().validate(customerDto,bindingResult);
//        if (bindingResult.hasErrors()){
//            model.addAttribute("customerDto",customerDto);
//            return "customer/edit";
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDto,customer);
//        customerService.save(customer);
//        return "redirect:/customer";
//    }
}
