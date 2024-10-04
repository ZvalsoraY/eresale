package first.resale.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "currency", length = 255)
    private String currency;

    public Deal() {
    }

    public Deal(Long sellerId, Long buyerId, Long productId, LocalDateTime dealDate, Float dealPrice, String currency) {
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.dealDate = dealDate;
        this.dealPrice = dealPrice;
        this.currency = currency;
    }

    /*public Deal(Long id, Long sellerId, Long buyerId, Long productId, LocalDateTime dealDate, Float dealPrice, String currency) {
        this.id = id;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.dealDate = dealDate;
        this.dealPrice = dealPrice;
        this.currency = currency;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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
