package first.resale.service;

import first.resale.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductService  extends PagingAndSortingRepository<Product, Long> {
    void save(Product product);
    void edit(long id, Product newProduct);
    void delete(long id);
    Product findById(long id);
}
