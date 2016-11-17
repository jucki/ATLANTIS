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

    public Player(int playerID) {
        this.playerID = playerID;
        this.cardHand = new CardHand();
        this.tileHand = new TileHand();
        if (this.playerID == 1) { //player1 always starts the game
            myTurn = true;
        } else {
            myTurn = false;
        }
    }

    public Player getPlayer() {
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


}
