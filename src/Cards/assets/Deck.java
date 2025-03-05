package Cards.assets;

import Cards.assets.enums.ESuit;
import Cards.assets.enums.EValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    List<Card> cards = new ArrayList<>(2);
    Card cardPlayer;
    Card cardComp;

    public Deck(){
        createCard();
        createCard();

        deal(cards);
        game(cardPlayer, cardComp);
        System.out.println(cardPlayer + " " + cardComp);
    }

    public void createCard() {
        ESuit[] types = ESuit.values();
        EValue[] values = EValue.values();

        Random random = new Random();
        int typeIndex = random.nextInt(4);
        int valueIndex = random.nextInt(13);

        ESuit type = types[typeIndex];
        EValue value = values[valueIndex];

        Card card = new Card(type, value);
        addCard(card);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void deal(List<Card> deck) {
        cardPlayer = deck.get(0);
        cardComp = deck.get(1);
    }

    public void game(Card cardPlayer, Card cardComp) {
        if (cardPlayer.getValue().getValueInt() > cardComp.getValue().getValueInt()) {
            System.out.println("Ganaste");
        } else if (cardPlayer.getValue().getValueInt() < cardComp.getValue().getValueInt()) {
            System.out.println("Perdiste");
        } else if (cardPlayer.getValue().getValueInt() == cardComp.getValue().getValueInt()) {
            System.out.println("Empate");
        }
    }
}
