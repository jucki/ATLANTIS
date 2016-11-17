package ch.fhnw.atlantis.Server.GameModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tobias on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * Contains all the cards in an ArrayList as well as cards that are not in the game anymore in another arrayList
 */
public class CardDeck implements Serializable {

    final int s = 15; //amount of cards per color

    private ArrayList<Card> deck = new ArrayList<Card>();
    private Card card;

    public CardDeck() {

    }

    /**
     * Creates ArrayList that contains 15 card objects per color (105 cards in total)
     */
    public void createCardDeck() {
        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.BLUE));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.BLACK));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.YELLOW));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.BROWN));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.WHITE));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.GREEN));
        }

        for (int i = 0; i < s; i++) {
            deck.add(new Card(Color.PINK));
        }
        Collections.shuffle(deck);
    }

    /**
     * @return ArrayList that contains 15 card objects per color (105 cards in total)
     */
    public ArrayList<Card> getCardDeck() {
        return deck;
    }

    /**
     * @return Number of cards in Deck     *
     */
    public int getNumberOfCardsInDeck() {
        return deck.size();
    }

    /**
     * @param num
     * @return Card at specific index
     */
    public Card getFromCardDeckAtIndex(int num) {
        return deck.get(num);
    }

    /**
     * @param player
     * Deals cards at the beginning of the game to each player
     */
    public void dealCardsAtBeginning(Player player) {
        if (player.getPlayerID() == 1) {
            for (int i = 0; i < 3; i++) {
                card = deck.get(0);
                player.getPlayerCardHand().add(card);
                deck.remove(0);
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                card = deck.get(0);
                player.getPlayerCardHand().add(card);
                deck.remove(0);
            }
        }
    }

}
