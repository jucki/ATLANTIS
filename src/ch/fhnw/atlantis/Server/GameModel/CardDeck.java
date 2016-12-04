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
     * Returns an ArrayList that contains 15 cards per color (105 cards in total)
     * @return ArrayList
     */
    public ArrayList<Card> getCardsFromCardDeck() {
        return deck;
    }

    /**
     * Returns the number of cards that still is in the deck
     * @return Number of cards in Deck     *
     */
    public int getNumberOfCardsInDeck() {
        return deck.size();
    }

    /**
     * Returns the card from the deck that is at the specific index
     * @param num
     * @return Card
     */
    public Card getFromCardDeckAtIndex(int num) {
        return deck.get(num);
    }

    /**
     * Deals cards at the beginning of the game to each player
     * @param player
     */
    public void dealCardsAtBeginning(Player player) {
        if (player.getPlayerID() == 1) {
            for (int i = 0; i < 4; i++) {
                card = deck.get(0);
                player.getPlayerCardHand().getCardHand().add(card); //2.12.16, had to add .getCardHand() in order that the add()-method works
                deck.remove(0);
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                card = deck.get(0);
                player.getPlayerCardHand().getCardHand().add(card); //2.12.16, had to add .getCardHand() in order that the add()-method works
                deck.remove(0);
            }
        }
    }

}
