package no.ntnu.matste;

import java.util.Random;

/**
 * Holds all 52 cards
 * @author Mats Hag Tellefsen
 * @version 2.0
 */

public class DeckOfCards {
    //class attributes
    private String[] deck;
    private String[] suit;


    /**
     * Constructor that sets up String arrays and creates 52 cards with a value and suit
     */

    DeckOfCards() {
        this.suit = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new String[52];
        int idx = 0;
        for(int i = 0; i < suit.length; i++) {
            char c = suit[i].charAt(0);
            for(int j = 0; j < 13; j++) {
                deck[idx] = c + "" + (j + 1);
                idx++;
            }
        }
    }


    /**
     * Method that deals a hand of cards to the player
     * @param n number of cards to be dealt
     * @return n number of cards
     */

    public Hand dealHand(int n) {
        Hand hand = new Hand(n);
        for(int i = 0; i < n; i++) {
            int random = new Random().nextInt(52);
            String card = deck[random];
            if(!hand.contains(card)) {
                hand.add(card);
            }
            else {
                i--;
            }
        }
        return hand;
    }
}
