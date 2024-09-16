package first.resale.models.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import first.resale.models.Currency;
import first.resale.models.Deal;
import first.resale.models.Product;
import first.resale.service.DealService;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.JAXBException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("products")
public class ProductController {
    private final UserService userService;
    private final ProductService productService;
    private final DealService dealService;
    private final GetCurrentCursController getCurrentCursController;

    public String getCursToRubByName(String name) throws JAXBException, JsonProcessingException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getCurrentCursController.getCourse(formatter.format(LocalDateTime.now()))
                .getValute().stream().filter(cur -> cur.getCharCode().equals(name))
                .map(inf -> inf.getVunitRate()).findFirst().get();
    }

    public ProductController(UserService userService, ProductService productService, DealService dealService, GetCurrentCursController getCurrentCursController) {
        this.userService = userService;
        this.productService = productService;
        this.dealService = dealService;
        this.getCurrentCursController = getCurrentCursController;
    }

    @GetMapping
    public String getProducts(Model model) throws JAXBException, JsonProcessingException {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("USD", getCursToRubByName("USD"));
        model.addAttribute("CNY", getCursToRubByName("CNY"));
        return "/product/products";
    }


    @GetMapping("/create")
    public String showCreatePage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("users", userService.getUsers());
        long currentUserId = userService.getUserByUserName(userDetails.getUsername()).getId();
        Product currentProduct = new Product();
        currentProduct.setUserId(currentUserId);
        model.addAttribute("product", currentProduct);
        model.addAttribute("currencies", Currency.values());
        return "/product/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        long currentUserId = userService.getUserByUserName(userDetails.getUsername()).getId();
        Product currentProduct = productService.getProductById(productId);
        Deal currentDeal = new Deal();
        var currentId = dealService.getDeals().stream().mapToLong(Deal::getId).max();
        currentDeal.setId(currentId.getAsLong() + 1);
        currentDeal.setProductId(productId);
        currentDeal.setBuyerId(currentUserId);
        currentDeal.setDealDate(LocalDateTime.now());
        currentDeal.setDealPrice(currentProduct.getPrice());
        currentDeal.setCurrency(currentProduct.getCurrency());
        currentDeal.setSellerId(currentProduct.getUserId());
        dealService.saveDeal(currentDeal);
        return "redirect:/deals";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}