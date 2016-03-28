package models;

/**
 * Created by Khartonov Oleg on 08.03.2016.
 */
public class Product {
    private int productId;
    private long price;
    private String info;

    public Product(int productId, long price, String info) {
        this.productId = productId;
        this.price = price;
        this.info = info;
    }

    public int getProductId() {
        return productId;
    }

    public long getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString(){
        return "Product ID " + productId + "\n"+
                "[" + "\n" +
                "info: " + info + "\n"+
                "price:" + price + "\n" +
                "]";
    }
}
