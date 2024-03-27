package first.resale.service.implementation;

import first.resale.models.Product;
import first.resale.repository.ProductRepository;
import first.resale.repository.UserRepository;
import first.resale.service.ProductService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }

    @Override
    public Product getProductById(Long id) {
        var product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new NoSuchElementException("Product not found.");
        }
    }

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        updatedProduct.setId(id);
        var product = productRepository.findById(id).get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setUserId(product.getId());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setCurrency(product.getCurrency());
        productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}