import java.util.Objects;

public class Customer {

    private int id;
    private String name;
    private double balance;
    private Basket basket;

    public Customer(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.basket = new Basket(this);
    }

    public Basket getBasket() {
        return basket;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void showBalance() {
        System.out.println("Ваш баланс: " + balance);
    }

    public void addMoney(double money) {
        balance += money;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return id == customer.id && Double.compare(balance, customer.balance) == 0 && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

}
