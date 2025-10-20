import clothing.Clothing;

import java.util.ArrayList;
import java.util.List;

public class Shop implements ShowItems {

    private String name;
    private List<Clothing> clothing;
    private List<Order> orders;
    private double bank;

    public Shop(String name, List<Clothing> clothing, double bank) {
        this.name = name;
        this.bank = bank;
        this.clothing = clothing;
        this.orders = new ArrayList<>();
    }

    public double getBank() {
        return bank;
    }

    public List<Clothing> getClothing() {
        return clothing;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void showItems() {
        showProducts();
    }

    private void showProducts() {
        int count = 1;
        for (Clothing oneThing : clothing) {
            System.out.println(count + ". " + oneThing);
            count++;
        }
    }

    public void addOrders(Order order) {
        orders.add(order);
    }

    public void addMoney(double price) {
        bank += price;
    }
}
