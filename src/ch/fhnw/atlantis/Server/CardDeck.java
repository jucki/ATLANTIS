package ch.fhnw.atlantis.Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tobias on 02.11.2016.
 *
 * Contains all the cards in an arrayList as well as cards that are not in the game anymore in another arrayList
 */
public class CardDeck implements Serializable {


    public static void main(String[] args) {   //does this have to be main???

        int s = 15; //amount of cards per color
        CardColor cColor;
        Card cards;


        ArrayList<Card> CardDeck = new ArrayList<Card>();
        ArrayList<Card> PlayedCards = new ArrayList<Card>(); //method that takes card from player hand into this list need to be written (maybe in player class)

        //The following loops create 15 cards per color set each and put those cards into the ArrayList "CardDeck"
        //Do these loops need to go into a method in order to call it when a new game is started?
        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.BLUE));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.BLACK));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.YELLOW));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.BROWN));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.WHITE));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.GREEN));
        }

        for (int i = 0; i < s; i++) {
            CardDeck.add(new Card(CardColor.PINK));
        }

        Collections.shuffle(CardDeck);

        /*Just for test purpose

        System.out.println(CardDeck.get(1).getCardPlayed());
        System.out.println(CardDeck.get(1).getCardValue());
        System.out.println(CardDeck.get(1).getPaymentValue());
        System.out.println(CardDeck.get(1).getCardColor());

        */
    }

}
