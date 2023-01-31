package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String show() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String search(@RequestParam String letter, Model model) {
        Map<String, String> maps = new HashMap<>();
        maps.put("Soccer", "Bóng đá");
        maps.put("Badminton", "Cầu lông");
//        for (Map.Entry<String, String> entry : maps.entrySet()) {
//            if (entry.getKey().equals(letter)) {
//                model.addAttribute("english",letter);
//                model.addAttribute("search", entry.getValue());
//                return "result";
//            }
//        }
//        model.addAttribute("message", "Not found");
        if (maps.containsKey(letter)){
            model.addAttribute("search",maps.get(letter));
        } else {
            model.addAttribute("search","not found");
        }
        return "result";
    }
}
