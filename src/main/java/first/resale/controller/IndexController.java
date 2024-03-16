package first.resale.controller;

import first.resale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
@GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        return "StartPage";
    }
}
