package first.resale.controller;

import first.resale.models.Currency;
import first.resale.models.Product;

import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
public class ProductController {
    private final UserService userService;
    private final ProductService productService;

    public ProductController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }
    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("products", productService.getProducts());
        return "/product/products";
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