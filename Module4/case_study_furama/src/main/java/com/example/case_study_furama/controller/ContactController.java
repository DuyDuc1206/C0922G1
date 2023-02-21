package com.example.case_study_furama.controller;

import com.example.case_study_furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("contract")
public class ContactController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("contractPage",contractService.findAllContract(pageable));
        return "contract/list";
    }
}
