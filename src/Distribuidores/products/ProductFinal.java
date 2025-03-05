package Distribuidores.products;

import Distribuidores.Enums.ProductType;

public class ProductFinal extends Product {

    public ProductFinal(String name, int colorIndex, double price, String description, double discount, String model) {
        super(name, ProductType.FINAL, Product.getColorByIndex(colorIndex), price, description, discount, model);
    }

    @Override
    public String toString() {
        return "Nombre: " + getName() +
                "\nColor: " + getColor().getValue() +
                "\nPrice: " + getPrice() +
                "\nDescription: " + getDescription() +
                "\nDiscount: " + getDiscount() +
                "\nModle: " + getModel();
    }
}
