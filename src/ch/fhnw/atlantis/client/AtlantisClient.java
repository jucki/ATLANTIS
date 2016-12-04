package ch.fhnw.atlantis.client;

/**
 * Created by Jonas on 07.11.2016.
 */

import java.util.List;

import ch.fhnw.atlantis.client.model.Card;
import ch.fhnw.atlantis.client.model.Figure;
import ch.fhnw.atlantis.client.model.GameState;
import ch.fhnw.atlantis.client.model.Tile;


public interface AtlantisClient {


    public int start();


    public List<Tile> getTiles(int playerId);//wieso playerID als Parameter?!?!?!?!?! -> sollte Array returnen die Tiles beinhaltet -> createTileDeck()
    // Returns initially shuffled list of tiles to placed on the board


    public List<Card> getDealedCards(int playerId);
    /**
     * Returns a List of Cards for one Player
     * @return
     */

    public Boolean isMyTurnNow(int playerId);
    // Returns true if this playersID's turn ------> moveNumber++

    public GameState move(int playerId, Card card, Figure figureToMove);
    // make a move with playerID, card pl
    //
    // ayed and figure to move

    public GameState pay(int playerId, List<Tile> tiles);
    // pay for water with list of tiles to pay

    public GameState playAnotherCard(int playerId, Card card);
    // play another card if necessary

}
