package first.resale.repository;

import first.resale.models.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Long> {
    List<Deal> findBySellerId(Long sellerId);
    List<Deal> findByBuyerId(Long buyerId);
}
