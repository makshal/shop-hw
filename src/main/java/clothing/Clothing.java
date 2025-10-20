package clothing;

public abstract class Clothing {

    private static int countId;

    private int id;
    private String name;
    private double price;
    private Size size;
    private Color color;
    private String material;
    private int quantity;

    public Clothing(String name, double price, Size size, Color color, String material, int quantity) {
        id = ++countId;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.material = material;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", color=" + color +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
