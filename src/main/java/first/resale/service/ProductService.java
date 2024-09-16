package first.resale.service;

import first.resale.models.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getProducts();

    List<Product> getProductsByUserId(Long userId);

    Product getProductById(Long id);

    void updateProduct(Long id, Product product);

    void deleteProductById(Long id);

}
