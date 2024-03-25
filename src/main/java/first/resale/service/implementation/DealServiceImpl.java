package first.resale.service.implementation;

import first.resale.models.Deal;
import first.resale.models.Product;
import first.resale.repository.DealRepository;
import first.resale.repository.ProductRepository;
import first.resale.repository.UserRepository;
import first.resale.service.DealService;
import first.resale.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    //@Autowired
    public DealServiceImpl(ProductRepository productRepository, UserRepository userRepository,
                           DealRepository dealRepository){
        this.dealRepository = dealRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public List<Deal> getDeals() {
        List<Deal> result = new ArrayList<>();
        dealRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Deal> getDealsByUserId(Long userId) {
        return dealRepository.findByUserId(userId);
    }

    @Override
    public Deal getDealById(Long id) {
        var deal = dealRepository.findById(id);
        if (deal.isPresent()) {
            return deal.get();
        } else {
            throw new NoSuchElementException("Deal not found.");
        }
    }

//    @Override
//    public void updateProduct(Long id, Product updatedProduct) {
//        updatedProduct.setId(id);
//        var product = productRepository.findById(id).get();
//        updatedProduct.setProductName(product.getProductName());
//        updatedProduct.setDescription(product.getDescription());
//        updatedProduct.setUserId(product.getId());
//        updatedProduct.setPrice(product.getPrice());
//        updatedProduct.setCurrency(product.getCurrency());
//        productRepository.save(updatedProduct);
//    }

    @Override
    public void deleteDeal(Long id) {
        dealRepository.deleteById(id);
    }
}