package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "/list";
    }

    @PostMapping("/delete")
    public String deleteBlog(int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/edit-form")
    public String showFormEdit(int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String viewBlog(int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @GetMapping("search")
    public String searchBlog(String name, Model model) {
        model.addAttribute("blogs", blogService.findByNameContaining(name));
        return "/list";
    }
}
