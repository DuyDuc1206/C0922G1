package com.example.case_study_furama.controller;

import com.example.case_study_furama.dto.FacilityDto;
import com.example.case_study_furama.model.facility.Facility;
import com.example.case_study_furama.service.facility.IFacilityService;
import com.example.case_study_furama.service.facility.IFacilityTypeService;
import com.example.case_study_furama.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String facilityTypeId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        model.addAttribute("facilityPage", facilityService.searchAndDisplay(name, facilityTypeId, pageable));
        model.addAttribute("facilityTypeList", facilityTypeService.findAllFacilityType());
        model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
        model.addAttribute("searchName", name);
        model.addAttribute("newFacilityDto", new FacilityDto());
        model.addAttribute("editFacilityDto", new FacilityDto());
        return "/facility/list";
    }

    @PostMapping("add")
    public String addFacility(@Validated @ModelAttribute("newFacilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirect,
                              @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityPage", facilityService.findAll(pageable));
            model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
            model.addAttribute("status", true);

            return "facility/list";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facility, facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("message", "Add Successfully!");
        return "redirect:/facility";
    }

    @PostMapping("delete")
    public String deleteFacility(@ModelAttribute("idDelete") Integer id, RedirectAttributes redirect) {
        facilityService.remove(id);
        redirect.addFlashAttribute("message", "Delete Successfully!");
        return "redirect:/facility";
    }

//    @PostMapping("edit")
//    public String editFacility(@Validated @ModelAttribute("editFacilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirect,
//                               @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
//        new FacilityDto().validate(facilityDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("facilityPage", facilityService.findAll(pageable));
//            model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
//            model.addAttribute("statusEdit", true);
//
//            return "facility/list";
//        }
//        Facility facility = new Facility();
//        BeanUtils.copyProperties(facilityDto, facility);
//        facilityService.save(facility);
//        redirect.addFlashAttribute("message", "Edit Successfully!");
//        return "redirect:/facility";
//    }
}
