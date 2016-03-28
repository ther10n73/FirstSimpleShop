package models;

/**
 * Created by Khartonov Oleg on 08.03.2016.
 */
public class User {
    private int userId;
    private int balance;
    private String fio;
    private String address;

    public User(int userId, int balance, String address, String fio) {
        this.userId = userId;
        this.balance = balance;
        this.fio = fio;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public int getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString(){
        return "UserId = " + userId + "\n" + "Balance = " + balance + "\n" + "Address: " + address + "\n" +"Fio: " + fio;
    }
}
