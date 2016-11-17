package ch.fhnw.atlantis.Server;

import ch.fhnw.atlantis.Server.GameController.GameController;
import ch.fhnw.atlantis.Server.GameModel.CardDeck;
import ch.fhnw.atlantis.Server.GameModel.Player;
import ch.fhnw.atlantis.Server.GameModel.TileDeck;

/**
 * Created by Tobias on 10.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class TestClass {

    public static void main(String[] args) {

        Player player1 = new Player(1); //instantiates a new player object with playerID 1. Also creates new playerHand
        Player player2 = new Player(2); //instantiates a new player object with playerID 2. also creates new playerHand
        CardDeck cardDeck = new CardDeck(); //new CardDeck Object that contains references to ArrayList cDeck and ArrayList playedCards;
        TileDeck tileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck
        TileDeck waterTileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck

        /*
        GameController gc = new GameController();
        gc.start();
        */

        cardDeck.createCardDeck();
        tileDeck.createTileDeck();
        waterTileDeck.createWaterTileDeck();

        System.out.println("Number of Cards in cardDeck: " + cardDeck.getNumberOfCardsInDeck());
        System.out.println("Number of Tiles in tileDeck: " + tileDeck.getNumberOfTilesInDeck());
        System.out.println("Number of Watertiles in waterTileDeck: " + waterTileDeck.getNumberOfWaterTilesInDeck());

        System.out.println("");

        cardDeck.dealCardsAtBeginning(player1);
        cardDeck.dealCardsAtBeginning(player2);
        System.out.println(player1.getPlayerCardHand().size());
        System.out.println(player2.getPlayerCardHand().size());
        System.out.println("Number of Cards in cardDeck after first deal: " + cardDeck.getNumberOfCardsInDeck());

        System.out.println("");
        System.out.println(player2.getMyTurn());

    }

}

