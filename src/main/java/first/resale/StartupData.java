package first.resale;

import first.resale.models.Currency;
import first.resale.models.Product;
import first.resale.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Component
public class StartupData implements CommandLineRunner {
    private final ProductService productService;

    @Autowired
    public StartupData(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        exampleProducts();
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

