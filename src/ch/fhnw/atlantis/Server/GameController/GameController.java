package ch.fhnw.atlantis.Server.GameController;

import ch.fhnw.atlantis.Server.GameModel.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Tobias on 08.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * Not quite sure if having x-1000 methods in a row is best-practice but if it looks stupid but works it is not stupid. Or is it better to define the object at the beginning so that less code has to be written?
 * Which one is better? Like in the drawCard()-method or updateFigureStatus()-method?**********************************************************
 */
public class GameController {

    private GameModel gameModel = new GameModel();
    private Player player, p1 ,p2;
    private Card c;
    private Tile t;
    private Figure f;
    private TileDeck td = gameModel.getTileDeck();    //is this good practice?
    private TileHand th;
    private ListIterator<Tile> tileDeckIterator = gameModel.getTileDeck().getTiles().listIterator(); //okay like that or should I define it in the method?

    //Constructor
    public GameController(GameModel gameModel) {
        this.gameModel = gameModel;
    }


    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                              Move Methods                                                    */
    /*                                                                                                              */
    /****************************************************************************************************************/


    /**
     * This is the move method and somewhat like the heart of the entire Game
     * @param playerID
     * @param figure
     * @param card
     */
    public void move(int playerID, Figure figure, Card card) { //Tile not necessary because I check where the next this-colored tile is
        if (checkMethod(playerID, figure, card) == true) {
            moveExecutionMethod(playerID, card, figure);
        } else {
            moveDenialMethod(playerID, card, figure);
        }
    }

    /*
    public void moveAgain(int playerID, Card card, Figure figure) {
        if (checkMethodAgain (playerID, card, figure) == true) {
            moveExecutioMethod(playerID, figure, card);
        } else {
            moveDenialMethod(playerID, card, figure):
        }
    }
    */


    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                                 Check Methods                                                */
    /*                                                                                                              */
    /****************************************************************************************************************/


    public boolean checkMethod(int playerID, Figure figure, Card card) {
        if (isFigureInGame(playerID, figure) == true && isPlayerAbleToPay(playerID, figure, card) == true) {
            return true;
        } else {
            return false;
        }
    }

    /****************************************************************************************************************/

    /**
     * Returns true if the figure is in the game and has not reached mainland yet, false otherwise
     * @param playerID
     * @param figure
     * @return boolean figureInGame, true if figure is in game, false if already reached mainland
     */
    public boolean isFigureInGame(int playerID, Figure figure) {
        if (gameModel.getPlayer(playerID).getFigure(figure).isFigureInGame() == true) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method checks whether the respective player has enough money in form of tiles OR cards in order to pay all the water crossings
     * @param playerID
     * @param figure
     * @param card
     * @return true if enough money, false otherwise
     */
    public boolean isPlayerAbleToPay(int playerID, Figure figure, Card card) {
        ListIterator<Tile> tileHandIterator = gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().listIterator(); //defines iterator for the tileHand
        int i = 0;
        int z = gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().size(); //checks how much "money" the player has in its hand in form of cards
        while (tileHandIterator.hasNext()) {                        // This iterator counts how much "money" the player has in its hand in form of tiles
            i += tileHandIterator.next().getTileValue();            // and stores it in the variable i
        }
        if (i >= calculateWaterCrossingPrice(card, figure) || z >= calculateWaterCrossingPrice(card, figure)) {
            return true;
        } else {
            return false;
        }
    }



    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                           Move Execution Methods                                             */
    /*                                                                                                              */
    /****************************************************************************************************************/

    /**
     * This is the main execution method that invokes the other methods that have to be invoked when a move is conducted
     * @param playerID
     * @param card
     * @param figure
     */
    public void moveExecutionMethod(int playerID, Card card, Figure figure) {
        findNextTileFigureCanGoTo(card, figure);
        calculateWaterCrossingPrice(card, figure);
        pickUpTileAndReplaceWithWater(playerID, card, figure);
        removeCardFromHand(playerID, card);
        updateTileStatus(card, figure);
        updateFigureStatus(playerID, figure, card);
        drawCard(playerID);
        updateTurnStatus();
    }

    /****************************************************************************************************************/

    /**
     * This method searches for the next tile a figure can be moved to
     * This method has been written with inspiration of this link: http://stackoverflow.com/questions/13316629/remove-objects-from-an-arraylist-based-on-a-given-criteria
     * @param card
     */
    public Tile findNextTileFigureCanGoTo(Card card, Figure figure) {
        while (tileDeckIterator.hasNext()) {
            t = tileDeckIterator.next();
            if (card.getCardColor() == t.getTileColor() && gameModel.getTileDeck().getTiles().indexOf(t) > figure.getAtIndex());
            return t;
        }
        return null;
    }

    /**
     * This method calculates the price that has to be paid for the respective move
     * @param card
     * @param figure
     * @return int toBePaid
     */
    public int calculateWaterCrossingPrice(Card card, Figure figure) {
        int toBePaid = 0;
        int i = figure.getAtIndex(); //asks for the figure's current index on the path
        t = findNextTileFigureCanGoTo(card, figure); //stores the next tile to which the figure ca go to in t
        int z = gameModel.getTileDeck().getTiles().indexOf(t); //asks for the index of t (the next tile figure can go to
        ListIterator<Tile> reverseTileDeckIterator = gameModel.getTileDeck().getTiles().listIterator(z); //creates ListIterator and defines where to start iterating

        while (reverseTileDeckIterator.hasPrevious() && reverseTileDeckIterator.previousIndex() >= i) { //defines the scope which has to be iterated
            if (reverseTileDeckIterator.previous().getIsWater() == true) { //"stops" when it hits a waterTile
                int u = reverseTileDeckIterator.previous().getTileValue(); //stores the value of the previous tile in variable u
                int v = reverseTileDeckIterator.next().getTileValue(); //stores the value of the next tile in variable v
                    if (v > u) { //compares both values and stores the larger of those in the toBePaid variable
                        toBePaid += v;
                    } else {
                        toBePaid +=u;
                    }

            }
        }
        return toBePaid;
    }

    /**
     * This method picks up the tile that is behind the figure (and that is not water) and replaces this particular tile with water
     * @param playerID
     * @param card
     * @param figure
     */
    public void pickUpTileAndReplaceWithWater(int playerID, Card card, Figure figure) {
        t = findNextTileFigureCanGoTo(card, figure); //finds the nex tile to which a figure can go to
        int i = td.getTiles().indexOf(t); //gets the index of this tile t, which is the next tile the figure can go to and stores it in i
        ListIterator<Tile> reverseTileDeckIterator = gameModel.getTileDeck().getTiles().listIterator(i); //creates ListIterator and defines where to start iterating
        while (reverseTileDeckIterator.hasPrevious()) { //iterates through the path
            if (reverseTileDeckIterator.previous().getIsOccupied() == false && reverseTileDeckIterator.previous().getIsWater() == false) { //Checks the condition
                gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().add(reverseTileDeckIterator.previous()); //adds this particular tile to the player's TileHand
                td.getTiles().set(reverseTileDeckIterator.previousIndex() + 1, gameModel.getWaterTileDeck().getTiles().get(0)); //replaces the tile in the tiledeck with a watertile. + 1 because previous(ndex() returns the index of the subsequent tile
            }
        }
    }

    /**
     * This method updates all the attributes and variables from a figure when a move is done
     * @param playerID
     * @param figure
     * @param card
     */
    public void updateFigureStatus(int playerID, Figure figure, Card card) {
        f = gameModel.getPlayer(playerID).getFigure(figure);
        //change leftAtlantis
        if (f.getLeftAtlantis() == false) { //sets the figure's leftAtlantis attribute to true with the 1st move
            f.setLeftAtlantis(true);
        }
        //change atIndex
        t = findNextTileFigureCanGoTo(card, figure);
        int i = gameModel.getTileDeck().getTiles().indexOf(t);
        f.setAtIndex(i);
        //change reachedMainland
        if (f.getAtIndex() > gameModel.getTileDeck().getTiles().size()) { //sets reachedMainland to true if figure is at a higher index than the size of the tileDeck is
            f.setReachedMainland(true);
        }
    }

    /**
     * Removes the card object given as argument from the player's cardHand
     * @param playerID
     * @param card
     */
    public void removeCardFromHand(int playerID, Card card) {
        gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().remove(card);
    }

    /**
     * Adds 1 card to respective player's cardhand and then deletes the
     * @param playerID
     */
    public void drawCard(int playerID) {
        c = gameModel.getCardDeck().getCardsFromCardDeck().get(0); //stores the object at index 0 in the card variable
        gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().add(c); //adds the card to the player's cardhand
        gameModel.getCardDeck().getCardsFromCardDeck().remove(0); //removes the object at index 0 from the carddeck
    }

    /**
     * Sets the isOccupied attribute of the tile the figure goes to to "true" and from the old tile to false
     * @param card
     * @param figure
     */
    public void updateTileStatus(Card card, Figure figure) {
        //set isOccupied to true
        t = findNextTileFigureCanGoTo(card, figure);
        t.setIsOccupied(true);
        //set old isOccupied to false
        int i = figure.getAtIndex();
        gameModel.getTileDeck().getTiles().get(i).setIsOccupied(false);
    }

    /**
     * This method changes the isMyTurn variable after the turn
     */
    public void updateTurnStatus() {
        p1 = gameModel.getPlayer(1);
        p2 = gameModel.getPlayer(2);
        if (p1.getMyTurn() == true) {
            p1.setMyTurn(false);
            p2.setMyTurn(true);
        } else {
            p1.setMyTurn(false);
            p2.setMyTurn(true);
        }
    }


    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                              Move Denial Method                                             */
    /*                                                                                                              */
    /****************************************************************************************************************/

    public String moveDenialMethod(int playerID, Card card, Figure figure) {
        if (isFigureInGame(playerID, figure) == false) {
            return "Your figure is not in the game anymore. Try again.";
        } else if (isPlayerAbleToPay(playerID, figure, card) == false) {
            return "You don't have enough points to pay this move. Try another move.";
        }
        return null;
    }


    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                   Methods Jonas needs for the front-end                                      */
    /*                                                                                                              */
    /****************************************************************************************************************/

    public boolean isMyTurn(int playerID) {
        return gameModel.getPlayer(playerID).getMyTurn();
    }



}
