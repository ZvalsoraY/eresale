package first.resale.repository;

import first.resale.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
/*    public Iterable<Product> findAll() {
        return null;
    }*/
}
