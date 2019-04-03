package blackjackfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    ArrayList<Card> dec;

    public String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    int cardsLeft;
    Card card;

    public Deck() {

    }

    public ArrayList<Card> createCards() {

        dec = new ArrayList<>();
        int cardCount = 0;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 13; j++) {

                Card c = new Card(suits[i], ranks[j]);
                dec.add(cardCount, c);
                cardCount++;

            }

        }
        return dec;

    }

    public Card draw() {

        int index = (int) (Math.random() * dec.size());

        card = dec.get(index);
        dec.remove(card);

        return card;

    }

    public int cardsLeft() {

        return 52 - cardsLeft;

    }

}
