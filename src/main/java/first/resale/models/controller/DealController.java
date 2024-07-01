package first.resale.models.controller;

import first.resale.service.DealService;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("deals")
public class DealController {
    private final DealService dealService;
    private final UserService userService;
    private final ProductService productService;

    public DealController(UserService userService, ProductService productService, DealService dealService) {
        this.dealService = dealService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping
    public String getDeals(Model model) {
        model.addAttribute("deals", dealService.getDeals());
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("products", productService.getProducts());
        return "/deal/deals";
    }

//    @DeleteMapping("/{id}")
//    public String deleteDeal(@PathVariable Long id) {
//        productService.deleteDeal(id);
//        return "redirect:/products";
//    }
}