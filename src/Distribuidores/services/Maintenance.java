package Distribuidores.services;

import Distribuidores.Enums.ServiceType;

public class Maintenance extends Service{
    public Maintenance(String name, String description, double cost, double discount) {
        super(name, description, cost, ServiceType.MAINTENANCE, discount);
    }

    @Override
    public String toString() {
        return "Servicion de mantenimiento:\n" +
                "Nombre del servicio: " + getName() +
                "\nDescripcion del servicio: " + getDescription() +
                "\nCosto del servicio: " + getCost() +
                "\nDescuento: " + getDiscount();
    }
}
