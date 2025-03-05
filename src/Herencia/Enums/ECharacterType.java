package Herencia.Enums;

public enum ECharacterType {
    WARRIOR("Warrior"),
    SORCERER("Sorcerer"),
    HUNTER("Hunter");

    private final String value;

    ECharacterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
