package com.example.test2.controller;

import com.example.test2.dto.PigDto;
import com.example.test2.model.Pig;
import com.example.test2.service.IOriginService;
import com.example.test2.service.IPigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pig")
public class PigController {
    @Autowired
    private IOriginService originService;

    @Autowired
    private IPigService pigService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "") String codePig,
                           @RequestParam(required = false,defaultValue = "") String stt,
                           @RequestParam(required = false,defaultValue = "")String origin,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "1") int size){
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("pigPage",pigService.findAll(codePig,stt,origin,pageable));
        model.addAttribute("originList",originService.findAll());
        model.addAttribute("pigDto",new PigDto());
        model.addAttribute("codePig",codePig);
        model.addAttribute("stt",stt);
        model.addAttribute("origin",origin);
        return "list";
    }

    @PostMapping("/delete")
    public String deletePig(@ModelAttribute("idDelete") Integer id, RedirectAttributes redirectAttributes){
        pigService.deletePig(id);
        redirectAttributes.addFlashAttribute("message","Delete Successfully!");
        return "redirect:/pig";
    }

    @PostMapping("/status")
    public String statusPig(@ModelAttribute("idPay") Integer id,RedirectAttributes redirectAttributes){
        pigService.edit(id);
        redirectAttributes.addFlashAttribute("message","Pay Successfully!");
        return "redirect:/pig";
    }
    @PostMapping("/add")
    public String createPig(@Validated @ModelAttribute("pigDto") PigDto pigDto, BindingResult bindingResult,
                            Model model,@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "1") int size,RedirectAttributes redirectAttributes){
        Pageable pageable = PageRequest.of(page, size);
        new PigDto().validate(pigDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("pigPage",pigService.finAllPig(pageable));
            model.addAttribute("pigDto",pigDto);
            model.addAttribute("originList",originService.findAll());
            model.addAttribute("flag",true);
            return "list";
        }
        Pig pig = new Pig();
        BeanUtils.copyProperties(pigDto,pig);
        pigService.savePig(pig);
        redirectAttributes.addFlashAttribute("message","Add Successfully!");
        return "redirect:/pig";
    }

    @GetMapping("/edit")
    public String editList(Integer id,Model model){

        PigDto pigDto = new PigDto();
        BeanUtils.copyProperties(pigService.findById(id),pigDto);
        model.addAttribute("originList",originService.findAll());
        model.addAttribute("pigDto",pigDto);
        return "edit";
    }
    @PostMapping("save")
    public String savePig(@Validated @ModelAttribute("pigDto") PigDto pigDto,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
        new PigDto().validate(pigDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("pigDto",pigDto);
            model.addAttribute("originList",originService.findAll());
            return "edit";
        }
        Pig pig = new Pig();
        BeanUtils.copyProperties(pigDto,pig);
        pigService.savePig(pig);
        redirectAttributes.addFlashAttribute("message","Edit Successfully!");
        return "redirect:/pig";
    }
}
