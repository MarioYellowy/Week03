package Distribuidores.Enums;

public enum ServiceType {
    MAINTENANCE("Matenimiento"),
    REPARATION("Reparacion");

    private final String value;

    ServiceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
