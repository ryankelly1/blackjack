package blackjackfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class BlackJackController implements Initializable {

    private final BlackJackFX view;
    private final Card card;
    private final Deck deck;
    private final Dealer dealer;
    int cnt;

    BlackJackController() {
        view = new BlackJackFX();
        card = new Card();
        deck = new Deck();
        dealer = new Dealer();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //get a random card form the card deck
    public String PlayCard() {

        deck.createCards();

        Card name = deck.draw();
        String card14 = name.toString();
        return card14;

    }

    //create the card rectangle 
    Rectangle getCard() {
        Rectangle cardFormat = card.getCard();
        return cardFormat;

    }

    //get the current chipcount
    String getChipCount() {
        String chips = Integer.toString(dealer.getChipCount());
        return chips;

    }
    
    //card text to add to view
    public StackPane Cards() {

        cnt = cnt + 1;
        StackPane stack = new StackPane();

        if (cnt < 6) {
            Text t2 = new Text(PlayCard());
            t2.setWrappingWidth(90);
            stack.getChildren().addAll(getCard(), t2);

            view.fp.getChildren().add(stack);

        } else {
            System.out.println("Card Limit reached");
        }
        return stack;
    }

}
