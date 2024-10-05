package first.resale.controller;

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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    private static final String GET_PRODUCTS_RESULT = "/product/products";
    private static final String SHOW_CREATE_RESULT = "/product/create";
    private static final String BUY_PRODUCT_RESULT = "redirect:/products";

    @InjectMocks
    private ProductController productController;

//    @InjectMocks
//    private GetCurrentCursController getCurrentCursController;
    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    @Mock
    private DealService dealService;

    @Mock
    private UserDetails userDetails;
    @Mock
    private Model model;

//    @BeforeEach
//    void setUp() {
//        userService = mock(UserService.class);
//    }

//    @Test
//    void getProductsTest() throws JAXBException, JsonProcessingException {
//
//        //doReturn("30").when(getCurrentCursController.getCourse(formatter.format(LocalDateTime.now())));
//        String usd = "30";
//        doReturn(usd).when(productService).getCursToRubByName("USD");
////        when(productController.getCursToRubByName("USD")).thenReturn("30");
////        when(productController.getCursToRubByName("CNY")).thenReturn("6");
//
////        doReturn("30").when(productController.getCursToRubByName("USD"));
////        doReturn("6").when(productController.getCursToRubByName("CNY"));
//        assertEquals(GET_PRODUCTS_RESULT, productController.getProducts(model));
//    }
    @Test
    void showCreatePageTest() {
        var userDetails = new org.springframework.security.core.userdetails.User(
                "user2", "user2", new HashSet<>());
        //User user = new User(3L, "testuser", "password", "testuser", "777", Role.USER.toString());
        var users = List.of(
                new User(4L, "user2", "user2", "user2", "7774", Role.USER.toString()),
                new User(5L, "testuser5", "password5", "testuser5", "7775", Role.USER.toString()),
                new User(6L, "testuser6", "password6", "testuser6", "7776", Role.USER.toString()));

        doReturn(users).when(userService).getUsers();
//        doReturn(users.get(1)).when(userService).getUserByUserName(userDetails.getUsername()).getId();
        when(userService.getUserByUserName("user2")).thenReturn( new User(4L, "user2", "user2", "user2", "7774", Role.USER.toString()));
        when(userService.getUserByUserName(userDetails.getUsername())).thenReturn( new User(4L, "user2", "user2", "user2", "7774", Role.USER.toString()));
 //       when(userService.getUserByUserName("user2").getId()).thenReturn(4L);
//        Product product = new Product(1L,"Prod 1","disc Prod 1",4L, 15.5F,"RUB");
//        doReturn(product).when().getUsers();

        //Mockito.when(diaryManagementService.getDiaryEntry(id)).thenReturn(diaryEntryResponse);

        assertEquals(SHOW_CREATE_RESULT, productController.newProduct(model,userDetails));
    }
    @Test
    void buyProductTest() {
        when(userService.getUserByUserName(userDetails.getUsername())).thenReturn( new User(4L, "user2", "user2", "user2", "7774", Role.USER.toString()));
        assertEquals(BUY_PRODUCT_RESULT, productController.buyProduct(4L,userDetails));
    }

    @Test
    void deleteProductTest() {
        var id = 4L;
        doNothing().when(productService).deleteProductById(4L);

        var response = productController.deleteProduct(id);

        verify(productService, times(1)).deleteProductById(4L);
        assertEquals("redirect:/products", response);
    }
}
