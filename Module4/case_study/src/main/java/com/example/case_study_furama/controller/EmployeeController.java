package com.example.case_study_furama.controller;

import com.example.case_study_furama.dto.EmployeeDto;
import com.example.case_study_furama.model.employee.Employee;
import com.example.case_study_furama.service.employee.IDivisionService;
import com.example.case_study_furama.service.employee.IEducationDegreeService;
import com.example.case_study_furama.service.employee.IEmployeeService;
import com.example.case_study_furama.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IPositionService positionService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String positionId,
                           @RequestParam(required = false, defaultValue = "") String degreeId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        model.addAttribute("employeePage", employeeService.getAllEmployee(name, positionId, degreeId, pageable));
        model.addAttribute("positionList", positionService.getAllPosition());
        model.addAttribute("educationDegreeList", educationDegreeService.getAllEducationDegree());
        model.addAttribute("divisionList", divisionService.getAllDivision());
        model.addAttribute("name", name);
        model.addAttribute("positionId", positionId);
        model.addAttribute("degreeId", degreeId);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/list";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("idDelete") Integer id, RedirectAttributes redirect) {
        employeeService.deleteEmployee(id);
        redirect.addFlashAttribute("mess", "Delete Successfully!");
        return "redirect:/employee";
    }

    @PostMapping("/add")
    public String createEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                 BindingResult bindingResult, RedirectAttributes redirect,
                                 @PageableDefault(page = 0, size = 5) Pageable pageable,
                                 Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("employeePage", employeeService.getAll(pageable));
            model.addAttribute("positionList", positionService.getAllPosition());
            model.addAttribute("educationDegreeList", educationDegreeService.getAllEducationDegree());
            model.addAttribute("divisionList", divisionService.getAllDivision());
            model.addAttribute("status", true);
            return "employee/list";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        redirect.addFlashAttribute("mess", "Add Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/edit")
    public String editEmployee(Integer id, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id), employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positionList", positionService.getAllPosition());
        model.addAttribute("educationDegreeList", educationDegreeService.getAllEducationDegree());
        model.addAttribute("divisionList", divisionService.getAllDivision());
        return "employee/edit";
    }

    @PostMapping("save")
    public String saveEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("positionList", positionService.getAllPosition());
            model.addAttribute("educationDegreeList", educationDegreeService.getAllEducationDegree());
            model.addAttribute("divisionList", divisionService.getAllDivision());
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        redirect.addFlashAttribute("mess", "Edit Successfully!");
        return "redirect:/employee";
    }
}
