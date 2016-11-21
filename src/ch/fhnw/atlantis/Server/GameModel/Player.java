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

    public Player getPlayer(int playerID) {
        return this;
    }

    public int getPlayerID() {
        return playerID;
    }

    public boolean getMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public ArrayList<Card> getPlayerCardHand() {
        return cardHand.getCardHand();
    }

    /*
    public Figure getFigure(int figureNumber) {
        return this.Figure;
    }
    */
}
