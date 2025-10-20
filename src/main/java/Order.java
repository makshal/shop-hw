import java.time.LocalDateTime;

public class Order {

    private double total;
    private LocalDateTime dateTime;
    private Basket basket;
    private Customer customer;

    public Order(Basket basket) {
        this.basket = basket;
        dateTime = LocalDateTime.now();
        total = basket.getTotal();
        customer = basket.getCustomer();
    }


    public double getTotal() {
        return total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean hasBalance() {
        return !(basket.getTotal() > basket.getCustomer().getBalance());
    }


    @Override
    public String toString() {
        return "Заказ{" +
                "Покупатель=" + customer.getId() + " " + customer.getName() +
                ", Дата=" + dateTime +
                ", Сумма=" + total +
                '}';
    }
}
