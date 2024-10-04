package first.resale;

import first.resale.models.Currency;
import first.resale.models.Deal;
import first.resale.models.Product;
import first.resale.models.Role;
import first.resale.models.User;
import first.resale.service.DealService;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class EresaleApplication {

    private static UserService userService;
    private static ProductService productService;
    private static DealService dealService;
    @Autowired
    private UserService auserService;
    @Autowired
    private ProductService aproductService;
    @Autowired
    private DealService adealService;

    @PostConstruct
    public void init() {
        EresaleApplication.userService = auserService;
        EresaleApplication.productService = aproductService;
        EresaleApplication.dealService = adealService;
    }
    public static void main(String[] args) {
        SpringApplication.run(EresaleApplication.class, args);


        /*for (User user: userService.getUsers())
        {
            for (Deal deal: dealService.getDealsBySellerId(user.getId())) {
                dealService.deleteDeal(deal.getId());
            }
            for (Deal deal:  dealService.getDealsByBuyerId(user.getId())) {
                dealService.deleteDeal(deal.getId());
            }
            //for (Product product: productService.getProductsByUserId(user.getId())){
            for (Product product: productService.getProductsByUser(user)){
                productService.deleteProductById(product.getId());
            }
            userService.deleteUserById(user.getId());
        }*/
        userService.saveUser( new User("admin", "admin", "admin", "1111", Role.ADMIN.toString()));
        userService.saveUser(new User("user", "user", "user", "2222", Role.USER.toString()));
        userService.saveUser(new User("user1", "user1", "user1", "22222", Role.USER.toString()));
        productService.saveProduct( new Product("Pr user","Product from user", userService.getUserByUserName("user"), 111f, Currency.USD.toString()));
        productService.saveProduct( new Product("Pr user1","Product from user1", userService.getUserByUserName("user1"), 101f, Currency.USD.toString()));
        dealService.saveDeal(
                new Deal(userService.getUserByUserName("user").getId()
                        , userService.getUserByUserName("user1").getId()
                        , productService.getProductsByUserId(userService.getUserByUserName("user").getId()).stream().findFirst().get().getId()
                        //, productService.getProductsByUser(userService.getUserByUserName("user")).stream().findFirst().get().getId()
                        , LocalDateTime.now()
                        ,111f
                        , Currency.USD.toString()));
    }
}