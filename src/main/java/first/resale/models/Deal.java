package first.resale.models;

import javax.xml.crypto.Data;
import java.sql.Timestamp;

public class Deal {
    private long id;
    private long sellerUserId;
    private long buyerUserId;
    private long productId;
    private Timestamp dealDate;
    private Number dealPrice;
    private Currency currency;
}
