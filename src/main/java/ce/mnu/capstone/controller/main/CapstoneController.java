package ce.mnu.capstone.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CapstoneController {
    @GetMapping("/")
    public String index () {
        return "redirect:/swagger-ui/index.html";
    }
}
