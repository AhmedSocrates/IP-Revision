package Controlers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    
    @GetMapping("/practice")
    public String showPlayground(Model model){
        model.addAttribute("simpleMsg", "Hello Thymeleaf");
        model.addAttribute("htmlMsg", "<Strong>This is BOLD text</Strong>");

        model.addAttribute("isAdmin", true);
        model.addAttribute("isStudent", false);
        
        model.addAttribute("Fruits", Arrays.asList("Apple","Orange"));

        model.addAttribute("role","MANAGER");
        model.addAttribute("userID",101);
        model.addAttribute("score",45);

        return "playground";
        
    }
}