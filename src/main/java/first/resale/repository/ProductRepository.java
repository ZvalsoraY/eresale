package first.resale.repository;

import first.resale.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
//    Product findById(long id);
//    Product findByTitle(String title);
//
//    List<Product> findAllByDate();
}
