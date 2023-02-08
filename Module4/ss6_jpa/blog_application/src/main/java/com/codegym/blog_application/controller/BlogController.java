package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.service.IBlogService;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("date").descending().and(Sort.by("name").ascending()));
        Page<Blog> blogPage = blogService.search(name, pageable);
        model.addAttribute("categoryList", categoryService.findAllCategory());
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("nameSearch", name);
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
        model.addAttribute("categoryList", categoryService.findAllCategory());
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
        model.addAttribute("categoryList", categoryService.findAllCategory());
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

//    @GetMapping("search")
//    public String searchBlog(String name, Model model) {
//        model.addAttribute("blogs", blogService.findByNameContaining(name));
//        return "/list";
//    }
}
