package ch.fhnw.atlantis.Server;

import java.util.List;

import ch.fhnw.atlantis.Server.GameModel.Card;
import ch.fhnw.atlantis.Server.GameModel.GameState;
import ch.fhnw.atlantis.Server.GameModel.Tile;
import ch.fhnw.atlantis.Server.GameModel.Figure;


/**
 * Interface has been written by Jonas & Tobias
 */

public interface AtlantisClient {

	/**
	 * Jonas gebastel, to be ignored at the moment
	 * @return
	 */
	public int start();


	/**
	 * Returns the list of tiles that represent the path
	 * @return List
	 */
	public List<Tile> getPathTiles();


	/**
	 * Returns the player's tiles
	 * @param playerId
	 * @return List
	 */
	public List<Tile> getPlayerTiles(int playerId);


	/**
	 * Returns the particular player's cards
	 * @param playerId
	 * @return List
	 */
	public List<Card> getDealedCards(int playerId);


	/**
	 * Returns the score of the particular player's cards
	 * @param playerId
	 * @return int
	 */
	public int getCardScore(int playerId);


	/**
	 * Returns the score of the particular player's tiles
	 * @param playerId
	 * @return int
	 */
	public int getTileScore(int playerId);


	/**
	 * Checks whether it is this player's turn or not, returns true if it is its turn, false otherwise
	 * @param playerId
	 * @return true if it is player's move, false otherwise
	 */
	public Boolean isMyTurnNow(int playerId);


    /**
     * This method is necessary in order to buy cards before every move (if player wants). Player can only give 1 tile in order to receive cards for this.
     * @param playerID
     * @param tile
     */
    public void buyCard(int playerID, Tile tile);


    /**
     * This method is required to make a move by a player.
     * @param playerId
     * @param card
     * @param figureToMove
     * @return GameState object
     */
	public GameState move(int playerId, Card card, Figure figureToMove);


    /**
     * This method handles the payment of the watercrossing with tile(s)
     * @param playerID
     * @param tile
     * @return
     */
	public GameState payWaterCrossingWithTile(int playerID, Tile... tile);


    /**
     * This method handles the payment of the waterCrossing with card(s)
     * @param playerID
     * @param card
     * @return
     */
    public GameState payWaterCrossingWithCard(int playerID, Card... card);

    //To be discussed
	public GameState playAnotherCard(int playerId, Card card);


	public String sendChatMessage(String sendMessage);


	public String receiveChatMessage(String recMessage);




	// play another card if necessary

	
	
}
