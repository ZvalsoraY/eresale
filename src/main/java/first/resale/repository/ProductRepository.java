package first.resale.repository;

import first.resale.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(long id);
    Product findByTitle(String title);

    List<Product> findAllByDate();
}
