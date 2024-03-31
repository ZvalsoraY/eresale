package first.resale.controller;

import first.resale.models.Currency;
import first.resale.models.Product;
import first.resale.service.DealService;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("deals")
public class DealController {
    private final DealService dealService;
    private final UserService userService;
    private final ProductService productService;

    public DealController(UserService userService, ProductService productService,
                          DealService dealService) {
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

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("product", new Product());
        model.addAttribute("currencies", Currency.values());
        return "/product/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}