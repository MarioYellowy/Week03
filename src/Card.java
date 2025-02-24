import enums.ESuit;
import enums.EValue;

public class Card {

    private final ESuit type;
    private final EValue value;

    public Card(final ESuit type, final EValue value){
        this.type = type;
        this.value = value;
    }

    public ESuit getType(){
        return type;
    }

    public EValue getValue(){
        return value;
    }

    @Override
    public String toString() {
        return type.getValue() + value.getValueStr();
    }
}
