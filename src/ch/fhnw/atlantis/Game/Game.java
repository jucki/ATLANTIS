package ch.fhnw.atlantis.Game;

import ch.fhnw.atlantis.Game.Controller.GameController;
import ch.fhnw.atlantis.Game.Model.*;

/**
 * Created by Tobias on 10.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class Game {

    public static void main(String[] args) {

        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel);

        gameModel.getPlayer(2).setMyTurn(true);
        System.out.println(gameModel.getPlayer(2).getMyTurn());

        gameModel.getPlayer(2).setMyTurn(false);
        System.out.println(gameModel.getPlayer(2).getMyTurn());

        System.out.println("Player1 has so many cards in its hand: " + gameModel.getPlayer(1).getPlayerCardHand().getCardHand().size());
        System.out.println("Player2 has so many cards in its hand: " + gameModel.getPlayer(2).getPlayerCardHand().getCardHand().size()); //Why can't I apply the method getCardTotal() from the CardHand class?

        System.out.println("WaterTileDeck contains: " + gameModel.getWaterTileDeck().getWaterTiles().size());
        System.out.println("CardDeck contains: " + gameModel.getCardDeck().getCardsFromCardDeck().size());
        System.out.println("TileDeck contains (with additional waterTile: " + gameModel.getTileDeck().getTiles().size());
        gameModel.getTileDeck().getTiles().remove(12);
        System.out.println("TileDeck now contains: " + gameModel.getTileDeck().getTiles().size());

        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(gameController.isMyTurnNow(2));
        System.out.println(gameController.isMyTurnNow(1));
        gameController.updateTurnStatus();
        System.out.println(gameController.isMyTurnNow(2));
        System.out.println(gameController.isMyTurnNow(1));



    }

}

