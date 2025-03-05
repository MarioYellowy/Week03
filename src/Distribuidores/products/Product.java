package Distribuidores.products;

import Distribuidores.Enums.ProductType;
import Distribuidores.Enums.Colors;

public class Product {

    private String name, description, model;
    private ProductType type;
    private Colors color;
    private double price, discount;

    public Product(String name, ProductType type, Colors color, double price, String description, double discount, String model) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public Colors getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setColor(Colors color) {
        this.color =  color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(float discount) {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model =  model;
    }

    public static Colors getColorByIndex(int index) {
        Colors[] colors  = Colors.values();
        if (index >= 0 && index < colors.length) {
            return colors[index];
        } else {
            throw new IllegalArgumentException("Invalid color index: " + index);
        }
    }
}
