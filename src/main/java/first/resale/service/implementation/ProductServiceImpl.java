package first.resale.service.implementation;

import first.resale.models.Product;
import first.resale.models.User;
import first.resale.repository.ProductRepository;
import first.resale.repository.UserRepository;
import first.resale.service.ProductService;
import first.resale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("Product not found with id: " + id));
        return product;
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }
/*    @Override
    public List<Product> getProductsByUser(User user) {
        return productRepository.findByUser(user);
    }*/

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        updatedProduct.setId(id);
        Product product = getProductById(id);
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setUser(product.getUser());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setCurrency(product.getCurrency());
        productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        if (getProductById(id) == null) {
            throw new NoSuchElementException("Produc not found");
        }
        productRepository.deleteById(id);
    }
}