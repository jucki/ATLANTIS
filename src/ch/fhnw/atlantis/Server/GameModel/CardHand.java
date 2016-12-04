package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;

/**
 * Created by Tobias on 03.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * 30.11.2016 I just realized that this class is not really necessary, such a list could also be created directly in the Player constructor
 */
public class CardHand {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private int cardTotal;
    private boolean isEmpty;

    //Constructor
    public CardHand() {
        cardTotal = cards.size();
        if (cardTotal > 0) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }
    }

    /**
     * Returns the CardHand of the corresponding player
     * @return ArrayList
     */
    public ArrayList<Card> getCardHand() {
        return cards;
    }

    /**
     * Returns the total value of a player's cardhand (1 card has a value of 1, therfore size of cardhand = cardTotal)
     * @return cardTotal
     */
    public int getCardTotal() {
        return cardTotal;
    }

    /**
     * Defines the CardTotal of a player's hand (I just realized that this method is not necessary)
     * @param cardTotal
     */
    public void setCardTotal(int cardTotal) {
        this.cardTotal = cardTotal;
    }

    /**
     * Returns whether player's hand is empty (true) or not (false)
     * @return
     */
    public boolean getIsEmpty() {
        return isEmpty;
    }

    /**
     * Sets the player's hand to empty (true) or not (false) (this method is actually not necessary)
     * @param isEmpty
     */
    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }


}
