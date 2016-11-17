package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;

/**
 * Created by Tobias on 03.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class CardHand {

    private ArrayList<Card> cardHand = new ArrayList<Card>();
    private int cardTotal;
    private boolean isEmpty;


    public CardHand() {
        cardTotal = cardHand.size();

        if (cardTotal > 0) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }


    }

    public ArrayList<Card> getCardHand() {
        return cardHand;
    }

    public int getCardTotal() {
        return cardTotal;
    }

    public void setCardTotal(int cardTotal) {
        this.cardTotal = cardTotal;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }


}
