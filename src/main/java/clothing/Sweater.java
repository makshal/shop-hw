package clothing;

public class Sweater extends Clothing {

    private String collarType;

    public Sweater(String name, double price, Size size, Color color, String material, int quantity, String collarType) {
        super(name, price, size, color, material, quantity);
        this.collarType = collarType;
    }

    public String getCollarType() {
        return collarType;
    }

    @Override
    public String toString() {
        return "Свитер{"
                + "название:" + getName() + ", "
                + "цена: " + getPrice() + ", "
                + "размер: " + getSize() + ", "
                + "цвет: " + getColor() + ", "
                + "материал: " + getMaterial() + ", "
                + "тип: " + getCollarType() +
                "}";
    }

}
