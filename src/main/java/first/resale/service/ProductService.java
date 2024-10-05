package first.resale.service;

import first.resale.models.Product;
import first.resale.models.User;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getProducts();

    Product getProductById(Long id);

    void updateProduct(Long id, Product product);

    void deleteProductById(Long id);

    List<Product> getProductsByUserId(Long userId);

}
