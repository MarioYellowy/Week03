package Distribuidores.services;

import Distribuidores.Enums.ServiceType;

public class Reparation extends Service{
    public Reparation(String name, String description, double cost, double discount) {
        super(name, description, cost, ServiceType.REPARATION, discount);
    }

    @Override
    public String toString() {
        return "Servicion de reparacion:\n" +
                "Nombre del servicio: " + getName() +
                "\nDescripcion del servicio: " + getDescription() +
                "\nCosto del servicio: " + getCost() +
                "\nDescuento: " + getDiscount();
    }
}
