package Cards.assets.enums;

public enum EValue {
    _2("2",2),
    _3("3", 3),
    _4("4", 4),
    _5("5", 5),
    _6("6", 6),
    _7("7", 7),
    _8("8", 8),
    _9("9", 9),
    _10("10", 10),
    J("J", 11),
    Q("Q", 12),
    K("K", 13),
    A("A", 14);

    private final String valueStr;

    private final int valueInt;


     EValue(String valueStr, int valueInt) {
        this.valueStr = valueStr;
        this.valueInt = valueInt;
    }

    public String getValueStr() {
        return valueStr;
    }

    public int getValueInt() {
         return valueInt;
    }
}
