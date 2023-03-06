package com.example.test.controller;

import com.example.test.dto.QuestionContentDto;
import com.example.test.model.QuestionContent;
import com.example.test.service.IQuestionContentService;
import com.example.test.service.IQuestionTypeService;
import com.example.test.service.IStatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private IQuestionContentService questionContentService;

    @Autowired
    private IQuestionTypeService questionTypeService;

    @Autowired
    private IStatusService statusService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String questionType,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tittle").ascending());
        model.addAttribute("questionContentPage", questionContentService.findAll(name, questionType, pageable));
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("statusList", statusService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("questionTypeId", questionType);
        model.addAttribute("questionContentDto", new QuestionContentDto());
        return "list";
    }

    @PostMapping("/delete")
    public String deleteQuestion(@ModelAttribute("idDelete") Integer id, RedirectAttributes redirect) {
        questionContentService.remove(id);
        redirect.addFlashAttribute("messages", "Delete Successfully!");
        return "redirect:/question";
    }

    @PostMapping("/create")
    public String createQuestion(@Validated @ModelAttribute("questionContentDto") QuestionContentDto questionContentDto,
                                 BindingResult bindingResult, RedirectAttributes redirect,
                                 Model model,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tittle").ascending());
        new QuestionContentDto().validate(questionContentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionContentPage", questionContentService.findQuestion(pageable));
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("statusList", statusService.findAll());
            model.addAttribute("questionContentDto", questionContentDto);
            model.addAttribute("flag", "true");
            return "list";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        questionContentService.saveQuestion(questionContent);
        redirect.addFlashAttribute("messages", "Add Successfully!");
        return "redirect:/question";
    }

    @GetMapping("edit")
    public String showEdit(Integer id, Model model) {
        QuestionContentDto questionContentDto = new QuestionContentDto();
        BeanUtils.copyProperties(questionContentService.findById(id), questionContentDto);
        model.addAttribute("questionContentDto",questionContentDto);
        model.addAttribute("questionTypeList",questionTypeService.findAll());
        model.addAttribute("statusList", statusService.findAll());
        return "edit";
    }
    @PostMapping("/save")
    public String saveQuestion(@Validated @ModelAttribute("questionContentDto") QuestionContentDto questionContentDto,BindingResult bindingResult,Model model,
                               RedirectAttributes redirect){
        new QuestionContentDto().validate(questionContentDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("questionContentDto",questionContentDto);
            model.addAttribute("questionTypeList",questionTypeService.findAll());
            model.addAttribute("statusList", statusService.findAll());
            return "edit";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto,questionContent);
        questionContentService.saveQuestion(questionContent);
        redirect.addFlashAttribute("messages","Edit Successfully!");
        return "redirect:/question";
    }
}
