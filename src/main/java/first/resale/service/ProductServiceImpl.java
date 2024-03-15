package first.resale.service;

import first.resale.models.Product;
import first.resale.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(long id, Product newProduct) {
        Product found = productRepository.findById(id);
        found.setUserId(newProduct.getUserId());
        found.setTitle(newProduct.getTitle());
        found.setDescription(newProduct.getDescription());
        found.setDatePlaced(newProduct.getDatePlaced());
        found.setPrice(newProduct.getPrice());
        found.setCurrency(newProduct.getCurrency());
        save(newProduct);
    }

    @Override
    public void delete(long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
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
