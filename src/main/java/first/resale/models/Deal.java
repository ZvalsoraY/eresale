package first.resale.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private Long id;
    @Column(name = "seller_id", nullable = false)
    private Long sellerId;
    @Column(name = "buyer_id", nullable = false)
    private Long buyerId;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "deal_date", nullable = false)
    private LocalDateTime dealDate;
    @Column(name = "deal_price")
    private Float dealPrice;
    @Column(name = "currency",length = 255)
    private String currency;

    public Deal() {
    }

    public Deal(long id, long sellerId, long buyerId, long productId, LocalDateTime dealDate, Float dealPrice, String currency) {
        this.id = id;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.dealDate = dealDate;
        this.dealPrice = dealPrice;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDateTime dealDate) {
        this.dealDate = dealDate;
    }

    public Float getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Float dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
