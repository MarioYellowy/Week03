package Distribuidores.products;

import Distribuidores.Enums.ProductType;

public class Accesory extends Product {

    public Accesory(String name, int colorIndex, double price, String description, double discount, String model) {
        super(name, ProductType.ACCESORIO, Product.getColorByIndex(colorIndex), price, description, discount, model);
    }

    @Override
    public String toString() {
        return "Accesorio: \n" +
                "Nombre: " + getName() +
                "\nColor: " + getColor().getValue() +
                "\nPrice: " + getPrice() +
                "\nDescription: " + getDescription() +
                "\nDiscount: " + getDiscount() +
                "\nModle: " + getModel();
    }
}
