package Distribuidores.Enums;

public enum ProductType {
    FINAL("Final"),
    ACCESORIO("Accesorio");

    private final String type;

    ProductType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
