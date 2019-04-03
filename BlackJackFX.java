package blackjackfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.beans.property.SimpleBooleanProperty;

public class BlackJackFX extends Application {

    BlackJackController bjc;
    Button Start;
    FlowPane fp = new FlowPane();
    Button Hit;
    int cnt = 0;
    public SimpleBooleanProperty edit = new SimpleBooleanProperty(false);

    public Parent gameBoard() {

        bjc = new BlackJackController();
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        Region background = new Region();
        background.setPrefSize(820, 620);
        background.setStyle("-fx-background-color: rgba(64, 64, 64, 1)");

        javafx.scene.layout.HBox HBoxLayout = new javafx.scene.layout.HBox(10);
        HBoxLayout.setPadding(new Insets(6, 6, 6, 6));

        //Creation of the gameboard
        Rectangle leftBG = new Rectangle(550, 600);
        Rectangle rightBG = new Rectangle(250, 600);
        VBox right = new VBox(20);
        VBox left = new VBox(45);

        leftBG.setFill(Color.DARKGREEN);
        rightBG.setFill(Color.CORNSILK);
        left.setPadding(new Insets(10, 10, 10, 10));
        left.setSpacing(8);
        right.setAlignment(Pos.CENTER);

        //Creation of the buttons/textfield on the right side of the gameboard
        TextField bet = new TextField("Enter Bet");
        bet.setDisable(true);
        bet.setMaxWidth(100);

        Text chips = new Text("Chip Count: " + bjc.getChipCount());
        Start = new Button("New Game");
        Button Hit = new Button("Hit");
        Button Stay = new Button("Stay");

        Start.disableProperty().bind(edit);
        Hit.disableProperty().bind(edit.not());
        Stay.disableProperty().bind(edit.not());
        bet.disableProperty().bind(edit.not());

        //adding all items to the pane
        javafx.scene.layout.HBox buttonsHBox = new javafx.scene.layout.HBox(20, Hit, Stay);
        buttonsHBox.setAlignment(Pos.CENTER);

        right.getChildren().addAll(bet, Start, chips, buttonsHBox);
        StackPane leftst = new StackPane(leftBG, left);
        StackPane rightst = new StackPane(rightBG, right);

        HBoxLayout.getChildren().addAll(leftst, rightst);
        pane.getChildren().addAll(background, HBoxLayout);

        fp.setAlignment(Pos.BOTTOM_CENTER);
        fp.setVgap(8);
        fp.setHgap(6);

        //Handling events for the events
        Start.setOnAction((javafx.event.ActionEvent value) -> {
            edit.set(true);
            fp.getChildren().addAll(bjc.Cards(), bjc.Cards());
            leftst.getChildren().addAll(fp);

        });

        Hit.setOnAction((javafx.event.ActionEvent value) -> {
            fp.getChildren().add(bjc.Cards());

        });

        Stay.setOnAction((javafx.event.ActionEvent value) -> {

        });

        return pane;

    }

    public static void main(String args[]) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(gameBoard()));
        primaryStage.setWidth(820);
        primaryStage.setHeight(632);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Welcome to Ceres Casino, You are Playing: BlackJack");
        primaryStage.show();
    }

}
