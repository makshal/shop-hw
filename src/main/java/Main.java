import clothing.Clothing;
import clothing.Color;
import clothing.Size;
import clothing.Sweater;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final double PRICE1 = 1040;
    private static final double PRICE2 = 2000;
    private static final double PRICE3 = 2550;
    private static final double PRICE4 = 1570;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nameShop = "HOME";

        Shop shop = new Shop(nameShop, Arrays.asList(
                new Sweater("Свитер1", PRICE1, Size.L, Color.BLACK, "Шерсть", 10, "Водолазка"),
                new Sweater("Свитер2", PRICE2, Size.S, Color.BROWN, "Шерсть", 30, "Свитшот"),
                new Sweater("Джинсы1", PRICE3, Size.M, Color.WHITE, "Джинса", 20, "Укороченные"),
                new Sweater("Джинсы2", PRICE4, Size.XL, Color.BLACK, "Джинса", 15, "Зауженные")
        ), 300_000);

        Customer customer = new Customer(1, "Максим", 20_000);
        Basket basket = customer.getBasket();


        System.out.println("Добро пожаловать в магазин: " + nameShop);

        while (true) {
            printMenu();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 1:
                    shop.showItems();
                    break;
                case 2:
                    shop.showItems();
                    System.out.println("Выберите номер товара: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    Clothing oneThing = shop.getClothing().get(index - 1);
                    basket.addInBasket(oneThing);
                    break;
                case 3:
                    basket.showItems();
                    break;
                case 4:
                    if (basket.getTotal() == 0) {
                        System.out.println("Корзина пуста!");
                        break;
                    }
                    Order order = new Order(basket);
                    if (order.hasBalance()) {
                        customer.addMoney(-basket.getTotal());
                        shop.addMoney(basket.getTotal());
                        basket.getClothing().forEach(item ->
                                item.setQuantity(item.getQuantity() - 1));
                        if (checkStorage(shop.getClothing())) {
                            shop.addOrders(order);
                            basket.clearBasket();
                            System.out.println("Заказ оформлен! Сумма: " + order.getTotal());
                            basket.setTotal(0);
                        } else {
                            System.out.println("Столько товара нет на складе!");
                            break;
                        }
                    } else {
                        System.out.println("Недостаточно средств на карте");
                    }
                    break;
                case 5:
                    shop.getOrders().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Банковский счет магазина: " + shop.getBank());
                    System.out.println("Баланс на карте покупателя: " + customer.getBalance());
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неизвестная команда");
            }
        }

    }

    public static void printMenu() {  // DRY
        System.out.println("1. Показать товары");
        System.out.println("2. Добавить в корзину");
        System.out.println("3. Посмотреть корзину");
        System.out.println("4. Купить (оформить заказ)");
        System.out.println("5. История заказов");
        System.out.println("6. Узнать балансы");
        System.out.println("0. Уйти");
        System.out.println();
    }

    public static boolean checkStorage(List<Clothing> clothing) {
        for (Clothing oneThing : clothing) {
            if (oneThing.getQuantity() < 0) {
                return false;
            }
        }
        return true;
    }

}
