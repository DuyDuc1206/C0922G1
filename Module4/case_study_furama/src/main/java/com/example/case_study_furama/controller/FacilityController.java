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
                           @RequestParam(defaultValue = "4") int size) {
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
    public String addFacility(@Validated @ModelAttribute("newFacilityDto") FacilityDto newFacilityDto, BindingResult bindingResult, RedirectAttributes redirect,
                              @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        new FacilityDto().validate(newFacilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("newFacilityDto", newFacilityDto);
            model.addAttribute("facilityPage", facilityService.findAll(pageable));
            model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
            model.addAttribute("status", true);
            model.addAttribute("editFacilityDto", new FacilityDto());
            return "facility/list";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(newFacilityDto, facility);
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

    @PostMapping("edit")
    public String editFacility(@Validated @ModelAttribute("editFacilityDto") FacilityDto editFacilityDto, BindingResult bindingResult, RedirectAttributes redirect,
                               @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        new FacilityDto().validate(editFacilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("editFacilityDto", editFacilityDto);
            model.addAttribute("facilityPage", facilityService.findAll(pageable));
            model.addAttribute("rentTypeList", rentTypeService.findAllRentType());
            model.addAttribute("statusEdit", true);
            model.addAttribute("newFacilityDto", new FacilityDto());
            return "facility/list";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(editFacilityDto, facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("message", "Edit Successfully!");
        return "redirect:/facility";
    }
}
