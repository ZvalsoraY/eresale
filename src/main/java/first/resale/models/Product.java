package first.resale.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name", length = 255, nullable = false)
    private String productName;
    @Column(name = "description", length = 500, nullable = false)
    private String description;
/*    @Column(name = "user_id", nullable = false)
    private Long userId;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "price")
    private Float price;
    @Column(name = "currency", length = 255)
    private String currency;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<User> user;*/
/*    @ManyToOne
    private User user;*/

    public Product() {
    }

    public Product( String productName, String description, User user, Float price, String currency) {
        this.productName = productName;
        this.description = description;
        this.user = user;
        this.price = price;
        this.currency = currency;
    }
    /*public Product(Long id, String productName, String description, Long userId, Float price, String currency) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.userId = userId;
        this.price = price;
        this.currency = currency;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }*/
    public User getUser() {
        return user;
    }

    public void setUser(User seller) {
        this.user = user;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}