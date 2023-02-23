package com.example.case_study_furama.controller;

import com.example.case_study_furama.model.contract.ContractDetail;
import com.example.case_study_furama.service.contract.IAttachFacilityService;
import com.example.case_study_furama.service.contract.IContractDetailService;
import com.example.case_study_furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("contract")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("contractDtoPage", contractService.findTotal(pageable));
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacilityList", attachFacilityService.findAttachFacility());
        return "contract/list";
    }

    @PostMapping("/attach-facility/add")
    public String createAttachFacility(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.saveContractDetail(contractDetail);
        return "redirect:/contract";
    }

}
