package first.resale.controller;

import first.resale.models.Product;
import first.resale.models.User;
import first.resale.repository.ProductRepository;
import first.resale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new Product());
        return "product";
    }
    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm, Model model) {

        productService.save(productForm);
        return "redirect:/home";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, Model model){
        Product product = productService.findById(productId);
        if (product != null){
            model.addAttribute("productForm", product);
            model.addAttribute("method", "edit");
            return "product";
        }else {
            return "error/404";
        }
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, @ModelAttribute("productForm") Product productForm, Model model){
        productService.edit(productId, productForm);
        return "redirect:/home";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            productService.delete(productId);
            return "redirect:/home";
        } else {
            return "error/404";
        }
    }
}