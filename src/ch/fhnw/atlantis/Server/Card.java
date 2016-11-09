package ch.fhnw.atlantis.Server;

import java.io.Serializable;

/**
 * Created by Tobias Gerhard on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * This class defines the cards and its methods.
 */

public class Card implements Serializable {

    private final int paymentValue; //defines the value of a card during the game
    private final int cardValue; //defines the value of the card at the end of the game
    private boolean cardPlayed; //false = in players hand, true = played by the player
    private boolean cardInGame; //card is in game as soon as game is started, if player pays with card, card is out of game
    private CardColor cColor;
    private Card card;

    //Constructor for card
    public Card(CardColor cColor) {
        paymentValue = 1;
        cardValue = 1;
        cardPlayed = false;
        cardInGame = true;
        this.cColor = cColor;
    }

    public int getPaymentValue() {
        return paymentValue;
    }

    public boolean getCardPlayed() {
        return cardPlayed;
    }

    public void setCardPlayed (boolean cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    public CardColor getCardColor() {
        return cColor;
    }

    public void setCardColor(CardColor cColor) {
        this.cColor = cColor;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardInGame(boolean cardInGame) {
        this.cardInGame = cardInGame;
    }

    public boolean getCardInGame() {
        return cardInGame;
    }

}
