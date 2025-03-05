package Distribuidores;

import java.time.LocalDateTime;

public class Adquisition<T>{

    private LocalDateTime date;
    private Client client;
    private T product;
    private String observations;

    public Adquisition(LocalDateTime date, Client client, T product, String observations) {
        this.date = date;
        this.client = client;
        this.product = product;
        this.observations = observations;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Fecha: " + getDate() +
                "\nCliente: " + (getClient().getName()) +
                "\nProducto: " + getProduct() +
                "\nObservaciones: " + getObservations();
    }
}
