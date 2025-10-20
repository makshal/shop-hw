package clothing;

public class Trouser extends Clothing {

    private String lengthType;

    public Trouser(String name, double price, Size size, Color color, String material, int quantity, String lengthType) {
        super(name, price, size, color, material, quantity);
        this.lengthType = lengthType;
    }

    public String getLengthType() {
        return lengthType;
    }

    @Override
    public String toString() {
        return "Джинсы{"
                + "название:" + getName() + ", "
                + "цена: " + getPrice() + ", "
                + "размер: " + getSize() + ", "
                + "цвет: " + getColor() + ", "
                + "материал: " + getMaterial() + ", "
                + "тип: " + getLengthType() +
                "}";
    }

}
