package first.resale.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private long id;
    @Column(name = "seller_id", nullable = false)
    private long sellerId;
    @Column(name = "buyer_id", nullable = false)
    private long buyerId;
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Column(name = "deal_date", nullable = false)
    private Timestamp dealDate;
    @Column(name = "deal_price")
    private Number dealPrice;
    @Column(name = "currency",length = 255)
    private Currency currency;
}
