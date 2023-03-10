package org.example.config.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public  String helloPage(@RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "surname", required = false) String surname,
                             Model model) {
//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello," + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
     public String calculator(@RequestParam(value = "a", required = false) int a, @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action",required = false) String action, Model model) {
        double result = 0;


        if (action.equals("multiplication")) {
            result = a * b;
        }
        if (action.equals("division")) {
            result = (double) a / b;
        }
        if (action.equals("subtraction")) {
            result = a - b;
        }
        if (action.equals("addition")) {
            result = a + b;
        }

        model.addAttribute("result", result);
        return "first/calculator";
    }
}
