package first.resale.service;

import first.resale.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductService  extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
