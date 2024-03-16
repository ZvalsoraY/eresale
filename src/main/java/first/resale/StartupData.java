package first.resale;

import first.resale.models.Currency;
import first.resale.models.Product;
import first.resale.models.Role;
import first.resale.models.User;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public StartupData(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setName("user");
        user.setPatronymic("userPatronymic");
        user.setSurname("userSurname");
        user.setBirthDay(new Date(88, 2, 15));
        user.setPhoneNumber("777");
        user.setStatus(Role.ROLE_USER.toString());
        user.setPassword("user");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setName("admin");
        admin.setPatronymic("userAdminPatronymic");
        admin.setSurname("userSurname");
        admin.setBirthDay(new Date(98, 2, 15));
        admin.setPhoneNumber("777");
        admin.setStatus(Role.ROLE_USER.toString());
        admin.setPassword("admin");

        userService.save(admin);
    }

    private void exampleProducts(){
        final long USERID = 1;
        final String TITLE = "Example Title";
        final String DESCRIPTION = "Example Description";
        final Timestamp DATEPLACED = new Timestamp(System.currentTimeMillis());
        final BigDecimal PRICE = BigDecimal.valueOf(22);
        final String CURRENCY = Currency.RUB.getValue();

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setUserId(USERID);
        product1.setTitle(TITLE);
        product1.setDescription(DESCRIPTION);
        product1.setDatePlaced(DATEPLACED);
        product1.setPrice(PRICE);
        product1.setCurrency(CURRENCY);

        productService.save(product1);

    }
}

