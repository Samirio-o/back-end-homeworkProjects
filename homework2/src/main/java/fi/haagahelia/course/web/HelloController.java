package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    //@GetMapping runs this method when someone visit with a GET request
    @GetMapping("/hello")
    //@RequestParam is used to get the parameters from the URL
    public String hello(@RequestParam String name, @RequestParam int age ,Model model) {
       //model is used to pass data to the view (HTML page)
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello";
    }
}
