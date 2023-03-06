package com.example.exam.controller;

import com.example.exam.dto.TacPhamDto;
import com.example.exam.model.TacPham;
import com.example.exam.service.ITacPhamService;
import com.example.exam.service.ITheLoaiService;
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
@RequestMapping("/tranh")
public class AppController {
    @Autowired
    private ITacPhamService tacPhamService;
    @Autowired
    private ITheLoaiService theLoaiService;
    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "") String ten,
                           @RequestParam(required = false,defaultValue = "") String theLoai,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "2") int size){
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("tacPhamPage",tacPhamService.findAll(ten,theLoai,pageable));
        model.addAttribute("theLoaiList",theLoaiService.finAll());
        model.addAttribute("tacPhamDto",new TacPhamDto());
        model.addAttribute("ten",ten);
        model.addAttribute("theLoai",theLoai);
        return "list";
    }
    @PostMapping("add")
    public String createTranh(@Validated @ModelAttribute("tacPhamDto") TacPhamDto tacPhamDto, BindingResult bindingResult,
                              RedirectAttributes redirect,Model model,
                              @RequestParam(required = false,defaultValue = "") String ten,
                              @RequestParam(required = false,defaultValue = "") String theLoai,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "2") int size ){
        Pageable pageable = PageRequest.of(page, size);
        new TacPhamDto().validate(tacPhamDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("tacPhamDto",tacPhamDto);
            model.addAttribute("tacPhamPage",tacPhamService.findAll(ten,theLoai,pageable));
            model.addAttribute("theLoaiList",theLoaiService.finAll());
            model.addAttribute("stt",true);
            return "list";
        }
        TacPham tacPham = new TacPham();
        BeanUtils.copyProperties(tacPhamDto,tacPham);
        tacPhamService.saveTacPham(tacPham);
        redirect.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/tranh";
    }
    @PostMapping("/xoa")
    public String deleteTranh(@ModelAttribute("idDelete") Integer id,RedirectAttributes redirectAttributes){
        tacPhamService.removeTacPham(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/tranh";
    }
}
