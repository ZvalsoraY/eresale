package first.resale.models;

import java.sql.Timestamp;

public class Product {
    private int id;
    private int userId;
    private String title;
    private String description;
    private Timestamp date;
    private Number price;
    private Currency currency;

    public int getId() {
        return id;
    }
}
