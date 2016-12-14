package ch.fhnw.atlantis.Game.Model;

/**
 * Created by Tobias on 20.11.2016(if sth. not written by Tobias, it is mentioned)
 */
public class GameModel {

    Player player1, player2;
    CardDeck cardDeck;
    TileDeck tileDeck;
    TileDeck waterTileDeck;

    //Constructor that calls the start() method
    public GameModel() {
        start();
    }

    /**
     * Creates two players, a cardDeck, tileDeck, and waterTileDeck, and deals cards to the respective players
     */
    public void start() {
        player1 = new Player(1); //instantiates a new player object with playerID 1. Also creates new playerHand
        player2 = new Player(2); //instantiates a new player object with playerID 2. also creates new playerHand
        cardDeck = new CardDeck(); //new CardDeck Object that contains references to ArrayList cDeck and ArrayList playedCards;
        tileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck
        waterTileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck

        cardDeck.createCardDeck();
        cardDeck.dealCardsAtBeginning(player1);
        cardDeck.dealCardsAtBeginning(player2);
        tileDeck.createTileDeck();
        waterTileDeck.createWaterTileDeck();

        tileDeck.getTiles().add(21, waterTileDeck.getWaterTiles().get(0)); //places the waterTile in the middle of the path
    }

    public Player getPlayer(int playerID) {
        if (playerID == 1) {
            return player1;
        } else {
            return player2;
        }
    }

    public TileDeck getTileDeck() {
        return tileDeck;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public TileDeck getWaterTileDeck() {
        return waterTileDeck;
    }

}
