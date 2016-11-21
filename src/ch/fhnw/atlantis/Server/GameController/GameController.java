package ch.fhnw.atlantis.Server.GameController;

import ch.fhnw.atlantis.Server.GameModel.CardDeck;
import ch.fhnw.atlantis.Server.GameModel.GameModel;
import ch.fhnw.atlantis.Server.GameModel.Player;
import ch.fhnw.atlantis.Server.GameModel.TileDeck;

/**
 * Created by Tobias on 08.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class GameController {

    GameModel gameModel;

    public GameController(GameModel gameModel) {
        this.gameModel = gameModel;
    }


    // GameLogic like that?!?!?!?!
    public boolean isMyTurn(int playerID) {
        return gameModel.getPlayer(playerID).getMyTurn();
    }

    /*
    public void start() {

        tileDeck.createTileDeck();
        waterTileDeck.createWaterTileDeck();
        cardDeck.createCardDeck();
        cardDeck.dealCardsAtBeginning(player1);
        cardDeck.dealCardsAtBeginning(player2);
    }
    */


//Game Logic comes here...

    /*
    public void move() {
        checkMethod1();
        checkMethod2();
        checkMethod3();
    }
    */


/*  Just some ideas:
        public void play(Player p, Card c){

            Tile tileThePlayerWantsToJumpOn = null;
            ArrayList<Tile> actualTileDeck = tileDeck.getTileDeck();
            for (int i=0; i< actualTileDeck.size(); i++){
                if (actualTileDeck.get(i).getTileColor() == c.getCardColor()){
                    tileThePlayerWantsToJumpOn = actualTileDeck.get(i);
                }
            }

            int fieldToJumpOn = tileDeck.getTileDeck().indexOf(tileThePlayerWantsToJumpOn);


            players.get(p).getCard(getCardFromCardDeck());
            return this;
        }
        */

    /*
    private boolean checkIfOccupied(int indexToCheck) {
    }
*/

}
