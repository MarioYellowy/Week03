package Distribuidores.services;

import Distribuidores.Enums.ServiceType;

public class Service {

    private String name, description;
    private double cost, discount;
    private ServiceType serviceType;

    public Service(String name, String description, double cost, ServiceType serviceType, double discount) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.serviceType = serviceType;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
