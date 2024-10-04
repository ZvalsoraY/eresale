//package first.resale.repository;
//
//import first.resale.models.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//public interface ProductUserRepository extends JpaRepository<Product, Long> {
//
//    @Transactional(readOnly = true)
//    @Query("select * from Products p where p.user.id=:id and p.title like :title")
//    List<Product> productUserName(long id);
//
//}
