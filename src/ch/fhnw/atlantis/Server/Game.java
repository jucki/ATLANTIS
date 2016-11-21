package ch.fhnw.atlantis.Server;

import ch.fhnw.atlantis.Server.GameController.GameController;
import ch.fhnw.atlantis.Server.GameModel.CardDeck;
import ch.fhnw.atlantis.Server.GameModel.GameModel;
import ch.fhnw.atlantis.Server.GameModel.Player;
import ch.fhnw.atlantis.Server.GameModel.TileDeck;

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

        System.out.println("Player1 has so many cards in its hand: " + gameModel.getPlayer(1).getPlayerCardHand().size());
        System.out.println("Player2 has so many cards in its hand: " + gameModel.getPlayer(2).getPlayerCardHand().size()); //Why can't I apply the method getCardTotal() from the CardHand class?

        System.out.println("WaterTileDeck contains: " + gameModel.getWaterTileDeck().size());
        System.out.println("CardDeck contains: " + gameModel.getCardDeck().size());

    }

}

