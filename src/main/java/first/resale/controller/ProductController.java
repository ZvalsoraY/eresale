package first.resale.controller;

import first.resale.models.Product;
import first.resale.models.User;
import first.resale.repository.ProductRepository;
import first.resale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    //private final ProductService productService;
    /*@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping
    public String getProductList(Model model, @AuthenticationPrincipal User user) {
        /*List<Product> products = productService.listAllProducts();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new Todo());
        return "todo";*/
        return null;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productShow";
    }

    @RequestMapping(value = "product/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productForm";
    }

    @RequestMapping(value = "product/new", method = RequestMethod.GET)
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    @RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}