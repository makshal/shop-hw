import clothing.Clothing;

import java.util.ArrayList;
import java.util.List;

public class Basket implements ShowItems {

    private Customer customer;
    private double total;

    private List<Clothing> clothing;

    public Basket(Customer customer) {
        this.customer = customer;
        this.clothing = new ArrayList<>();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addInBasket(Clothing oneThing) {
        this.clothing.add(oneThing);
        sum(oneThing.getPrice());
    }

    @Override
    public void showItems() {
        showBasket();
    }

    private void showBasket() {
        if(clothing.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            clothing.forEach(System.out::println);
        }
    }

    public List<Clothing> getClothing() {
        return clothing;
    }

    public void clearBasket() {
        this.clothing = new ArrayList<>();
    }

    private void sum(Double price) {
        total += price;
    }

    public double getTotal() {
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }
}
