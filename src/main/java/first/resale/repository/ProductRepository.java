package first.resale.repository;

import first.resale.models.Product;
import first.resale.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(Long user_id);

}
