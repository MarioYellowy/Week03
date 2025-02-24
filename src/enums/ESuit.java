package enums;

public enum ESuit {
    TREBOL("T"),
    DIAMANTES("D"),
    CORAZONES("C"),
    ESPADAS("E");

    private final String value;

    ESuit(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
