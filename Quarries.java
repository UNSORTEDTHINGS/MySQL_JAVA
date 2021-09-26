package database;

public enum Quarries {
    INSERT("INSERT INTO product (sku, name, org_price , sell_price , qty) VALUES (?, ?, ?, ?, ?)"),
    DELETE("DELETE FROM product WHERE name = ?"),
    SELECT("select * from product");
    private final String STATEMENT;

    Quarries(String s) {
        this.STATEMENT = s;
    }

    public String GET_STATEMENT() {
        return STATEMENT;
    }
}
