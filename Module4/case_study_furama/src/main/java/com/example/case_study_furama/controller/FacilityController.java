package com.example.case_study_furama.controller;

import com.example.case_study_furama.service.facility.IFacilityService;
import com.example.case_study_furama.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false,value = "") String name,
                           @RequestParam(required = false,value = "") String facilityId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("name").ascending());
        model.addAttribute("facilityPage",facilityService.searchAndDisplay(name,facilityId,pageable));
        model.addAttribute("facilityTypeList",facilityTypeService.findAllFacilityType());
        return "faciliy/list";
    }
}
