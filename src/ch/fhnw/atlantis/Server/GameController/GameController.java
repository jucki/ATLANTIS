package ch.fhnw.atlantis.Server.GameController;

import ch.fhnw.atlantis.Server.GameModel.CardDeck;
import ch.fhnw.atlantis.Server.GameModel.Player;
import ch.fhnw.atlantis.Server.GameModel.TileDeck;

/**
 * Created by Tobias on 08.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class GameController {


    Player player1 = new Player(1); //instantiates a new player object with playerID 1. Also creates new playerHand
    Player player2 = new Player(2); //instantiates a new player object with playerID 2. also creates new playerHand
    CardDeck cardDeck = new CardDeck(); //new CardDeck Object that contains references to ArrayList cDeck and ArrayList playedCards;
    TileDeck tileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck
    TileDeck waterTileDeck = new TileDeck(); //new tileDeck Object that contains references to ArrayList playedTiles, waterTilesDeck, and tileDeck

    public void start() {
        tileDeck.createTileDeck();
        waterTileDeck.createWaterTileDeck();
        cardDeck.createCardDeck();
        cardDeck.dealCardsAtBeginning(player1);
        cardDeck.dealCardsAtBeginning(player2);
    }


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
