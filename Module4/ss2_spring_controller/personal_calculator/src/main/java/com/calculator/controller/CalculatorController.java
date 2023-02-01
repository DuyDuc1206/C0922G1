package com.calculator.controller;

import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String showCalculator() {
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam(value = "number1",required = false,defaultValue = "0") float number1, @RequestParam(value = "number2",required = false,defaultValue = "0") float number2, @RequestParam String operation, Model model) {
        float result = 0;
        String cal = "";
        switch (operation) {
            case "+":
                result = number1 + number2;
                cal = "Addition";
                break;
            case "-":
                result = number1 - number2;
                cal = "Subtraction";
                break;
            case "*":
                result = number1 * number2;
                cal = "Multiplication";
                break;
            case "/":
                result = number1 / number2;
                cal = "Division";
                break;
            default:
        }
        model.addAttribute("cal",cal);
        model.addAttribute("result", result);
        return "index";
    }
}
