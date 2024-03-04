package first.resale.models;

import javax.xml.crypto.Data;
import java.sql.Timestamp;

public class Deal {
    private int id;
    private int sellerUserId;
    private int buyerUserId;
    private int itemId;
    private Timestamp date;
    private Number price;
    private Currency currency;
}
