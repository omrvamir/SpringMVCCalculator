package ru.omrvamir.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) Integer a,
                                 @RequestParam(value = "b", required = false) Integer b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {

        int result = 0;

        if (action == null)
            return "calculatorWithoutParameters";

        if (action.equals("multiplication"))
            result = a * b;
        else if (action.equals("addition"))
            result = a + b;
        else if (action.equals("subtraction"))
            result = a - b;
        else if (action.equals("division")) {
            if (b == 0)
                result = -1;
            else
                result = a / b;
        } else
            return "calculatorWithoutParameters";

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);

        return "calculator";
    }
}
