package database;

public class Product {

    private String sku;
    private String name;
    private double original_price;
    private double sell_price;
    private int qty;

    public Product(String sku, String name, double sell_price) {
        this.sku = sku;
        this.name = name;
        this.sell_price = sell_price;
    }

    public Product(String sku, String name, double original_price, double sell_price, int qty) {
        this.sku = sku;
        this.name = name;
        this.original_price = original_price;
        this.sell_price = sell_price;
        this.qty = qty;
    }

    public Product() {

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", original_price=" + original_price +
                ", sell_price=" + sell_price +
                ", qty=" + qty +
                '}';
    }
}
