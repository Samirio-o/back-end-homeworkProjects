package fi.haagahelia.homework1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class HelloController {
    @GetMapping("/index")
    public String index() {
        return "This is the main page";
    }

    @GetMapping("/contact")
    public String contact() {
        return "This is the contact page";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String location, @RequestParam String name) {
        return "Welcome to the " + location + " " + name + "!";
    }
    
}