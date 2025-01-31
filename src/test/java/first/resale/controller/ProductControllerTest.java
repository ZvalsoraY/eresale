package first.resale.controller;

import first.resale.models.Currency;
import first.resale.models.Deal;
import first.resale.models.Product;
import first.resale.models.Role;
import first.resale.models.User;
import first.resale.models.controller.ProductController;
import first.resale.service.DealService;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    private static final String SHOW_CREATE_EXPECTED = "/product/new";
    private static final String BUY_PRODUCT_EXPECTED = "redirect:/deals";
    private static final String DELETE_PRODUCT_EXPECTED = "redirect:/products";

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    @Mock
    private DealService dealService;


    @Mock
    private Model model;

    @Test
    void showCreatePageTest() {
        var userDetails = new org.springframework.security.core.userdetails.User(
                "user2", "user2", new HashSet<>());

        String result = productController.newProduct(model, userDetails);

        assertEquals(SHOW_CREATE_EXPECTED, result);
    }

    @Test
    void buyProductTest() {
        Long productId = 1L;
        User user = new User(
                "user2", "user2", "user2", "7774", Role.USER.toString());
        user.setId(1L);
        Product product = new Product(
                "Pr user", "Product from user", user, 111f, Currency.USD.toString());
        product.setId(productId);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                "user2", "user2", new HashSet<>());
        when(userService.getUserByUserName(userDetails.getUsername())).thenReturn(user);
        when(productService.getProductById(productId)).thenReturn(product);
        Deal deal = new Deal();
        deal.setId(1L);
        when(dealService.getDeals()).thenReturn(List.of(deal));

        String result = productController.buyProduct(productId, userDetails);

        assertEquals(BUY_PRODUCT_EXPECTED, result);
    }

    @Test
    void deleteProductTest() {
        var id = 4L;
        doNothing().when(productService).deleteProductById(4L);

        String result = productController.deleteProduct(id);

        assertEquals(DELETE_PRODUCT_EXPECTED, result);
    }
}
