package first.resale.models.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String get(Model model) {
        model.addAttribute("title", "Форма входа");
        return "/authentication/login";
    }
}
