package no.ntnu.matste;

/**
 * Class that holds cards dealt from the deckofcards class
 * @author Mats Hag Tellefsen
 * @version 2.0
 */

public class Hand {

    private String[] hand;
    private int index;

    /**
     * Initializes the Hand Array
     * @param n size of hand
     */
    Hand(int n) {
        hand = new String[n];
        index = 0;
    }

    /**
     * adds a card to the hand
     * @param card
     */

    public void add(String card) {
        hand[index] = card;
        index++;
    }

    /**
     * Checks if the hand contains a card or not
     * @param card
     * @return true/false
     */

    public boolean contains(String card) {
        for(int i = 0; i < hand.length; i++) {
            if(hand[i] != null && hand[i].equals(card)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Calculates the sum of all cards in hand
     * @return
     */

    public int calculateSum() {
        int sum = 0;
        for(int i = 0; i < hand.length; i++) {
            sum += Integer.parseInt(hand[i].substring(1, hand[i].length()));
        }
        return sum;
    }


    /**
     * finds all Heart suited cards from hand
     * @return String of Hearts found
     */

    public String getHearts() {
        String s = "";
        for(int i = 0; i < hand.length; i++) {
            if(hand[i].charAt(0) == 'H') {
                s += hand[i] + " ";
            }
        }
        if(!s.contains("H")) {
            s = "No Hearts";
        }
        return s;
    }


    /**
     * Checks if the hand contains a queen of spades
     * @return true/false
     */

    public boolean hasQueenOfSpades() {
        for(int i = 0; i < hand.length; i++) {
            if(hand[i].equals("S12")) {
                return true;
            }
        }
        return false;
    }



    /**
     * Checks if hand contains a Flush (5 suited cards)
     * @return true/false
     */
    public boolean fiveFlush() {
        char suit = hand[0].charAt(1);
        for(int i = 0; i < hand.length; i++) {
            if(suit != hand[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks the size of the hand
     * @return size of hand array
     */

    public int size() {
        return hand.length;
    }


    /**
     * Returns the cards in the hand as a String
     * @return String of Hand array
     */

    @Override
    public String toString() {
        String h = "";
        for(int i = 0; i < hand.length; i++) {
            h += hand[i] + " ";
        }
        return h;
    }
}
