package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;

/**
 * Created by Tobias on 11.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class Player {

    private CardHand cardHand;
    private TileHand tileHand;
    private int playerID;
    private boolean myTurn;
    private Figure figure, figure1, figure2, figure3;

    /**
     * Player constructor
     * @param playerID
     */
    public Player(int playerID) {
        this.playerID = playerID;
        cardHand = new CardHand();
        tileHand = new TileHand();
        figure1 = new Figure(this, 1);
        figure2 = new Figure(this, 2);
        figure3 = new Figure(this, 3);
        if (this.playerID == 1) { //player1 always starts the game
            myTurn = true;
        } else {
            myTurn = false;
        }
    }

    /**
     * Returns the playerID
     * @param playerID
     * @return playerID
     */
    public Player getPlayer(int playerID) {
        return this;
    }

    /**
     * Returns the playerID of the respective player
     * @return playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * Returns true if it is the player's turn, false otherwise
     * @return myTurn
     */
    public boolean getMyTurn() {
        return myTurn;
    }

    /**
     * Sets MyTurn attribute to true or false
     * @param myTurn
     */
    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    /**
     * Returns the player's cardHand
     * @return ArrayList cardHand
     */
    public CardHand getPlayerCardHand() {
        return cardHand;
    }

    public Figure getFigure(Figure figure) {
        if (figure.getFigureNumber() == 1) {
            return figure1;
        } else if (figure.getFigureNumber() == 2) {
            return figure2;
        } else if (figure.getFigureNumber() == 3) {
            return figure3;
        }
        return null;
    }

    public TileHand getPlayerTileHand() {
        return tileHand;
    }

}
