package ch.fhnw.atlantis.Game.Model;

import java.io.Serializable;

/**
 * 
 * @author Jonas & Tobias -> Idea comes from Jonas
 *
 */

public class GameState implements Serializable {

    private static final long serialVersionUID = 123456L;

	private boolean playAnotherCard;
	private int pay;
	private boolean okay;
	private boolean isFigureInGame;
	private boolean isPlayerAbleToPay;
    private boolean gameOver;

	//Constructor
	public GameState() {
		this.playAnotherCard = false; //true if player has to play another card
		this.pay = 0; //if pay > 0 Jonas says "Hey, you have to pay"
		this.okay = true; //true if everything is okay with the move, false otherwise (if player has to play another card or has to pay
		this.isFigureInGame = false; //true if figure is between Atlantis and Mainland, false otherwise
		this.isPlayerAbleToPay = true; //true if player has enough "money" to pay the move, false otherwise
        this.gameOver = false; //true if game is over (e.g. player unable to pay), false otherwise
	}

	public void setGameState(boolean playAnotherCard, int pay, boolean okay, boolean isFigureInGame, boolean isPlayerAbleToPay, boolean gameOver) {
		this.playAnotherCard = playAnotherCard;
		this.pay = pay;
		this.okay = okay;
		this.isFigureInGame = isFigureInGame;
		this.isPlayerAbleToPay = isPlayerAbleToPay;
        this.gameOver = gameOver;
	}

    /**
     * Defines whether the player has to play another card (e.g. if tile is occupied) or not (false)
     * @param playAnotherCard
     */
	public void setPlayAnotherCard(boolean playAnotherCard) {
        this.playAnotherCard = playAnotherCard;
    }

    public void setPay(int price) {
        this.pay = price;
    }

    public void setOkay(boolean okay) {
        this.okay = okay;
    }

    public void setFigureInGame(boolean inGame) {
        this.isFigureInGame = inGame;
    }

    public void setPlayerAbleToPay(boolean ableToPay) {
        this.isPlayerAbleToPay = ableToPay;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}








