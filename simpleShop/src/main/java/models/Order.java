package models;

/**
 * Created by Khartonov Oleg on 08.03.2016.
 */
public class Order {
    private int orderId;
    private int sum;
    private String listProduct;
    private String address;
    private int userId;

    public Order(int orderId, int sum, String listProduct, String address, int userId) {
        this.orderId = orderId;
        this.sum = sum;
        this.listProduct = listProduct;
        this.address = address;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSum() {
        return sum;
    }

    public String getListProduct() {
        return listProduct;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        return "Order_id: " + orderId + "\n"
                + "[" + "\n"
                + "sum: " + sum + "\n"
                + "products: " + listProduct + "\n"
                + "address: " + address + "\n"
                + "]";
    }
}
