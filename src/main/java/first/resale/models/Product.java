package first.resale.models;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "product")
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userId")
    @NotNull

    private long userId;
    @Column(name = "title",length = 255)
    @NotNull()
    private String title;
    @Column(name = "description",length = 255)
    @NotNull()
    private String description;
    @Column(name = "datePlaced",length = 255)
    @NotNull()
    private Timestamp datePlaced;
    @Column(name = "price",length = 255)
    @NotNull()
    private Number price;
    @Column(name = "currency",length = 255)
    @NotNull()
    private String currency;

    public Product() {
    }

    public Product(long id, long userId, String title, String description, Timestamp datePlaced, Number price, String currency) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.datePlaced = datePlaced;
        this.price = price;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getDatePlaced() {
        return datePlaced;
    }

    public Number getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatePlaced(Timestamp datePlaced) {
        this.datePlaced = datePlaced;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
