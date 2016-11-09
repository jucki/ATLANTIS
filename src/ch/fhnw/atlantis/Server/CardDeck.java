package ch.fhnw.atlantis.Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tobias on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * Contains all the cards in an arrayList as well as cards that are not in the game anymore in another arrayList
 */
public class CardDeck implements Serializable {

    int s = 15; //amount of cards per color

    ArrayList<Card> CardDeck = new ArrayList<Card>();
    ArrayList<Card> PlayedCards = new ArrayList<Card>(); //method that takes card from player hand into this list need to be written (maybe in player class)

    /**
     * @return ArrayList that contains 15 card objects per color (105 cards in total)
     */
    public ArrayList<Card> createCardDeck() {
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
        return CardDeck;
    }

    /**
     * @return ArrayList that contains 15 card objects per color (105 cards in total)
     */
    public ArrayList<Card> getCardDeck() {
        return CardDeck;
    }

    /**
     * @return ArrayList that contains the cards that are not in the game anymore
     */
    public ArrayList getPlayedCards() {
        return PlayedCards;
    }

        /*Just for test purpose

        System.out.println(CardDeck.get(1).getCardPlayed());
        System.out.println(CardDeck.get(1).getCardValue());
        System.out.println(CardDeck.get(1).getPaymentValue());
        System.out.println(CardDeck.get(1).getCardColor());

        */

}
