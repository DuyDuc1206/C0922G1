package com.example.music_information.controller;

import com.example.music_information.dto.MusicDto;
import com.example.music_information.model.Music;
import com.example.music_information.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musics", musicService.findAll());
        return "/list";
    }

    @GetMapping("edit-form")
    public String showFormEdit(int id, Model model) {
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(musicService.findById(id), musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("edit")
    public String editMusic(@Validated @ModelAttribute MusicDto musicDto, BindingResult bindingResult, Model model) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("musicDto",new MusicDto());
        return "create";
    }
}
