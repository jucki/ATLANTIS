package ch.fhnw.atlantis.Game.Model;

import java.io.Serializable;

/**
 * Created by Tobias Gerhard on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * This class defines the cards and its methods.
 */

public class Card implements Serializable {

    private static final long serialVersionUID = 345678L;

    private final int paymentValue; //defines the value of a card during the game
    private final int cardValue; //defines the value of the card at the end of the game
    private boolean cardPlayed; //false = in players hand, true = played by the player
    private boolean cardInGame; //card is in game as soon as game is started, if player pays with card, card is out of game
    private Color color;

    //Constructor for card
    public Card(Color cColor) {
        this.paymentValue = 1;
        this.cardValue = 1;
        this.cardPlayed = false;
        this.cardInGame = true;
        this.color = cColor;
    }

    /**
     * Returns the paymentValue of a card, which is always 1
     * @return paymentValue
     */
    public int getPaymentValue() {
        return paymentValue;
    }

    /**
     * Returns boolean whether card has already been played or not (I just realized that we do not need this attribute)
     * @return cardPlayed
     */
    public boolean getCardPlayed() {
        return cardPlayed;
    }

    /**
     * sets boolean whether the card has been played (true) or not (false) (I just realized that we do not need this attribute)
     * @param cardPlayed
     */
    public void setCardPlayed (boolean cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    /**
     * Returns the color of the card
     * @return color
     */
    public Color getCardColor() {
        return color;
    }

    /**
     * Sets the color for a card (actually, I just realized that this method is not really necessary)
     * @param color
     */
    public void setCardColor(Color color) {
        this.color = color;
    }

    /**
     * Retturns the cardValue which is always 1, respectively equal to the paymentValue
     * @return
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     * Define whether the card is in the game (true) or out of the game (false)
     * @param cardInGame
     */
    public void setCardInGame(boolean cardInGame) {
        this.cardInGame = cardInGame;
    }

    /**
     * Returns the CardInGame attribute - true if in game, false otherwise
     * @return cardInGame
     */
    public boolean getCardInGame() {
        return cardInGame;
    }

}
