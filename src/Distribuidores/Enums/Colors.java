package Distribuidores.Enums;

public enum Colors {
    BLUE("Azul"),
    RED("Rojo"),
    GREEN("Verde"),
    BLACK("Negro"),
    WHITE("Blanco"),
    YELLOW("Amarillo"),
    GRAY("Gris"),
    GOLD("Dorado");

    private final String value;
    Colors(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
