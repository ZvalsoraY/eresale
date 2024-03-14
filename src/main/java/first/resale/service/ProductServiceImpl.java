package first.resale.service;

import first.resale.models.Product;
import first.resale.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/*@Service*/
public class ProductServiceImpl implements ProductService{

    //@Autowired
    private ProductRepository productRepository;

    //@Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        /*return productRepository.findOne(id);*/
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
        //return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
       // return null;
       // productRepository.delete(id);
    }

    @Override
    public Iterable<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }
}
