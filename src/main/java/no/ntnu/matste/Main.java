package no.ntnu.matste;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/**
 * Main class of the application that launches the GUI
 * @author Mats Hag Tellefsen
 * @version 2.0
 */

public class Main extends App {

    /**
     * main method to start the application
     */

    public static void main(String[] args) {
        launch(args);
    }

    static DeckOfCards deck;
    static Hand hand = null;


    /**
     * Sets the primary stage
     */

    @Override
    public void start(Stage primaryStage) {
        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 300, 300);
        TextArea area = new TextArea();

        layout.setBackground(new Background(new BackgroundFill(Color.rgb(80,80,80), CornerRadii.EMPTY, Insets.EMPTY)));

        deck = new DeckOfCards();
        Button button = new Button("Deal Hand");
        button.setOnAction((event) -> {
            hand = deck.dealHand(5);
            area.setText(hand.toString());
        });

        Button button2 = new Button("Check Hand");
        button2.setOnAction((event) -> {
            if (hand != null) {
                area.appendText("\n");
                area.appendText("Sum of card values: " + hand.calculateSum() + "\n");
                area.appendText(hand.getHearts() + "\n");
                area.appendText("Has Queen of Spades: " + hand.hasQueenOfSpades() + "\n");
                area.appendText("Is it a flush?: " + hand.fiveFlush() + "\n");
            }
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);

        vbox.getChildren().addAll(area, button, button2);
        layout.getChildren().addAll(vbox);

        primaryStage.setTitle("Kortspill Miniprosjekt");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
