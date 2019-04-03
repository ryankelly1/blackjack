package blackjackfx;

import javafx.scene.Parent;
import javafx.scene.paint.Color;

public class Card extends Parent {

    String suit;
    String rank;
    int value;

    Card(String suit1, String rank1) {
        suit = suit1;
        rank = rank1;

    }

    Card() {

    }

    public javafx.scene.shape.Rectangle getCard() {
        javafx.scene.shape.Rectangle card1 = new javafx.scene.shape.Rectangle(90, 140);
        card1.setArcHeight(10);
        card1.setArcWidth(10);
        card1.setFill(Color.WHITE);

        return card1;

    }


    @Override
    public String toString() {
        return rank + " of " + suit;

    }
}
