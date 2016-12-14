package ch.fhnw.atlantis.Server.GameController;

import ch.fhnw.atlantis.Server.AtlantisClient;
import ch.fhnw.atlantis.Server.GameModel.*;

import java.util.*;

/**
 * Created by Tobias on 08.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * Questions: Should I add all getters to the model so that if I want sth., then I can just access it via 1 method?
 * Not quite sure if having x-1000 methods in a row is best-practice but if it looks stupid but works it is not stupid. Or is it better to define the object at the beginning so that less code has to be written?
 * Which one is better? Like in the drawCard()-method or updateFigureStatus()-method?**********************************************************
 */
public class GameController implements AtlantisClient {

    private GameModel gameModel = new GameModel();
    private GameState gameState = new GameState();
    private Player player, p1 ,p2;
    private Card c;
    private Tile t;
    private Figure f, figure1, figure2, figure3;
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
    /*                                          Move, Buy & Pay Methods                                             */
    /*                                                                                                              */
    /****************************************************************************************************************/

    /**
     * This is the move method and somewhat like the heart of the entire Game
     * @param playerID
     * @param figure
     * @param card
     */
    public GameState move(int playerID, Figure figure, Card card) { //Tile not necessary because I check where the next this-colored tile is //public GameModel?
        gameState.setGameState(false, 0, true, true, true, false); //resets gameState-Object's attributes
        if (checkMethod(playerID, figure, card) == true) {
            moveExecutionMethod(playerID, card, figure);
        } else {
            moveDenialMethod(playerID, card, figure);
        }
        return gameState;
    }

    //TBD
    public void moveAgain(int playerID, Card card, Figure figure) {
        if (checkMethod(playerID, figure, card) == true) { //how can I make it that it takes the same figure as before?
            moveExecutionMethod(playerID, card, figure);
            //updateAndSend Tiles, Cards, Figure, PathMethod() ????;
        } else {
            moveDenialMethod(playerID, card, figure);
        }
    }

    /**
     * Method is responsible for the watercrossing payment. Counts which tile is given as argument its value to the tilesValue variable, then removes the tile out of the player's tileHand
     * @param playerID
     * @param tile
     * @return GameState
     */
    public GameState payWaterCrossingWithTile(int playerID, Tile... tile) { //wie kann ich DIE particular tiles nehmen (in line 71), die ich der Methode eingebe?
        int tilesValue = 0;
        for (Tile t : tile) {
            tilesValue += t.getTileValue(); //increments variable tilesValue by the tiles' value for each tile given as argument
            gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().remove(t); //removes the respective tile from the player's tileHand
            gameState.setOkay(true); //changes the gameState
            gameState.setPay(0);
        }
        return gameState;
    }

    /** DONE
     * Method is responsible for the watercrossing payment. Counts for each card given as argument 1+, then removes the card out of the player's cardHand
     * @param playerID
     * @param card
     * @return gameState
     */
    public GameState payWaterCrossingWithCard(int playerID, Card... card) { //wie kann ich DIE particular card nehmen, die ich der Methode eingebe?
        int cardsValue = 0;
        for (Card c : card) {
            cardsValue++; //increments variable cardValue by 1 for each card given as argument
            gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().remove(c); //removes the respective card from the player's hand
            gameState.setOkay(true);
            gameState.setPay(0);
        }
        return gameState;
    }

    /**
     * This method is handles the card buying
     * @param playerID
     * @param tile
     */
    public void buyCard(int playerID, Tile tile) {
        int i = 1;
        int numberOfCards = tile.getTileValue() / 2; //calculates how many cards the player gets (since it is an integer, uneven numbers are rounded
        while (i < numberOfCards) {
            c = gameModel.getCardDeck().getCardsFromCardDeck().get(0); //stores the object at index 0 in the card variable
            gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().add(c); //adds the card to the player's cardhand
            gameModel.getCardDeck().getCardsFromCardDeck().remove(0); //removes the object at index 0 from the carddeck
        }
    }


    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                                 Check Methods                                                */
    /*                                                                                                              */
    /****************************************************************************************************************/

    /**
     * This is the method that contains all the check methods
     * @param playerID
     * @param figure
     * @param card
     * @return
     */
    public boolean checkMethod(int playerID, Figure figure, Card card) {
        if (isFigureInGame(playerID, figure) == true && isPlayerAbleToPay(playerID, figure, card) == true) {
            return true;
        } else {
            return false;
        }
    }

    /****************************************************************************************************************/

    /** DONE
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

    /** DONE
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
    public GameState moveExecutionMethod(int playerID, Card card, Figure figure) { //The order of these methods is important
        findNextTileFigureCanGoTo(card, figure);
        calculateWaterCrossingPrice(card, figure);
        pickUpTileAndReplaceWithWater(playerID, card, figure);
        removeCardFromHand(playerID, card);
        updateTileStatus(card, figure);
        updateFigureStatus(playerID, figure, card);
        drawCard(playerID);
        checkCardStackAndShuffle();
        updateTurnStatus(); //has to be the last method since it is in a thread on the client side
        return gameState;
    }

    /****************************************************************************************************************/

    /**
     * This method searches for the next tile a figure can be moved to
     * This method has been written with inspiration of this link: http://stackoverflow.com/questions/13316629/remove-objects-from-an-arraylist-based-on-a-given-criteria
     * @param card
     * @param figure
     */
    public Tile findNextTileFigureCanGoTo(Card card, Figure figure) { //checks to which tile the figure can be moved to
        while (tileDeckIterator.hasNext()) {
            t = tileDeckIterator.next();
            if (card.getCardColor() == t.getTileColor() && gameModel.getTileDeck().getTiles().indexOf(t) > figure.getAtIndex());
                if (t.getIsOccupied() == true) {
                    gameState.setPlayAnotherCard(true); //tell the player to play another card
                    //return t;
                } else if (!tileDeckIterator.hasNext()) { //if there is no tile left anymore that could be checked an matches the card color, then go to MainLand
                    t = null; //set the t that you return to null
                    gameState.setOkay(true); //this move is valid
                    figure.setReachedMainland(true); //figure is now at MainLand
            }
        }
        return t;
    }

    /** DONE
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
                    if (v < u) { //compares both values and stores the larger of those in the toBePaid variable
                        toBePaid += v;
                    } else {
                        toBePaid +=u;
                    }
            }
        }
        if (toBePaid > 0) {
            gameState.setPay(toBePaid);
        } else {
            //do nothing
        }
        return toBePaid;
    }

    /** DONE ---- These conditions may throw an indexOutOfBoundsException)
     * This method picks up the tile that is behind the figure (and that is not water) and replaces this particular tile with water
     * @param playerID
     * @param card
     * @param figure
     */
    public void pickUpTileAndReplaceWithWater(int playerID, Card card, Figure figure) {
        t = findNextTileFigureCanGoTo(card, figure); //finds the next tile to which a figure can go to
        int i = td.getTiles().indexOf(t); //gets the index of this tile t, which is the next tile the figure can go to and stores it in i
        ListIterator<Tile> reverseTileDeckIterator = gameModel.getTileDeck().getTiles().listIterator(i); //creates ListIterator and defines where to start iterating

        if (gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) == 0) {
            //do not pick up a tile
        } else if (gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) > 0 && gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) <= gameModel.getTileDeck().getTiles().size()){ //if it is a tile between the 2nd tile and Mainland, then pick up a tile
            while (reverseTileDeckIterator.hasPrevious()) { //iterates through the path
                if (reverseTileDeckIterator.previous().getIsOccupied() == false && reverseTileDeckIterator.previous().getIsWater() == false) { //Checks the condition
                    gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().add(reverseTileDeckIterator.previous()); //adds this particular tile to the player's TileHand
                    td.getTiles().set(reverseTileDeckIterator.previousIndex() + 1, gameModel.getWaterTileDeck().getWaterTiles().get(0)); //replaces the tile in the tileDeck with a watertile. + 1 because previous(index() returns the index of the subsequent tile
                }
            }
        } else if ((gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) + 1) == gameModel.getTileDeck().getTiles().size()) { //if you end up at MainLand, pick up the last tile behind it
            //search for the last tile that is not occupied and remove it
        } else if (gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) == 1) { //if it is the 2nd tile where you can go to, then pick up the 1st tile. If occupied, do nothing
            if (gameModel.getTileDeck().getTiles().get(0).getIsOccupied() == false) {
                gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().add(gameModel.getTileDeck().getTiles().get(0)); //adds the 1st tile to the player's tileHand
                gameModel.getTileDeck().getTiles().remove(0);
            } else if (gameModel.getTileDeck().getTiles().get(0).getIsOccupied() == true){ //if 1st tile is occupied, do nothing
                //do nothing
            }
        } else if ((gameModel.getTileDeck().getTiles().indexOf(findNextTileFigureCanGoTo(card, figure)) + 2) > gameModel.getTileDeck().getTiles().size()) { //if figure ends up on atlantis then pick up the last tile and do not remove it with water, if occupied, take the next possible and remove it with water
            if (gameModel.getTileDeck().getTiles().get(gameModel.getTileDeck().getTiles().size() - 1).getIsOccupied() == false) { //if not occupied, pick the last tile before mainland up and do NOT replace it
                gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().add(gameModel.getTileDeck().getTiles().get(gameModel.getTileDeck().getTiles().size() - 1)); //adds the last tile to the player's tileHand
                gameModel.getTileDeck().getTiles().remove(gameModel.getTileDeck().getTiles().size() - 1); //removes the last tile from the tileDeck
            } else { //if occupied, then search for the next one that could be picked up and replace it with water
                while (reverseTileDeckIterator.hasPrevious()) { //iterates through the path (code copied from above)
                    if (reverseTileDeckIterator.previous().getIsOccupied() == false && reverseTileDeckIterator.previous().getIsWater() == false) { //Checks the condition
                        gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().add(reverseTileDeckIterator.previous()); //adds this particular tile to the player's TileHand
                        td.getTiles().set(reverseTileDeckIterator.previousIndex() + 1, gameModel.getWaterTileDeck().getWaterTiles().get(0)); //replaces the tile in the tileDeck with a watertile. + 1 because previous(index() returns the index of the subsequent tile
                    }
                }
            }
        }
    }

    /** DONE
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

    /** DONE
     * Removes the card object given as argument from the player's cardHand and adds it to the played cards stack
     * @param playerID
     * @param card
     */
    public void removeCardFromHand(int playerID, Card card) {
        gameModel.getCardDeck().getPlayedCardsDeck().add(card); //adds this particular card to the played cards stack
        gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().remove(card); //removes this particular card from the player's cardHand
    }

    /** DONE
     * Adds 1 card to respective player's cardhand and then deletes the card out of the carddeck
     * Adds 2 cards to respective player's cardhand when he has 1 player on mainland
     * Adds 3 cards to respective player's cardhand when he has 2 players on mainland
     * @param playerID
     */
    public void drawCard(int playerID) {
        Figure f1 = gameModel.getPlayer(playerID).getFigure(figure1);
        Figure f2 = gameModel.getPlayer(playerID).getFigure(figure2);
        Figure f3 = gameModel.getPlayer(playerID).getFigure(figure3);
        int i = 1;
        if (f1.getReachedMainland() == false && f2.getReachedMainland() == false && f3.getReachedMainland() == false) {
            c = gameModel.getCardDeck().getCardsFromCardDeck().get(0); //stores the object at index 0 in the card variable
            gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().add(c); //adds the card to the player's cardhand
            gameModel.getCardDeck().getCardsFromCardDeck().remove(0); //removes the object at index 0 from the carddeck
        } else if (f1.getReachedMainland() == true || f2.getReachedMainland() == true || f3.getReachedMainland() == true){
            while (i <= 2) { //player has to take 2 cards if 1 figure is on mainland yet
                c = gameModel.getCardDeck().getCardsFromCardDeck().get(0); //stores the object at index 0 in the card variable
                gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().add(c); //adds the card to the player's cardhand
                gameModel.getCardDeck().getCardsFromCardDeck().remove(0); //removes the object at index 0 from the carddeck
                i++;
            }
        } else if ((f1.getReachedMainland() == true && f2.getReachedMainland() == true) || (f2.getReachedMainland() == true && f3.getReachedMainland() == true) ||
                (f3.getReachedMainland() == true && f1.getReachedMainland() == true)); {
            while (i <= 3) { //player has to draw 3 cards if 2 figures are on mainland yet
                c = gameModel.getCardDeck().getCardsFromCardDeck().get(0); //stores the object at index 0 in the card variable
                gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().add(c); //adds the card to the player's cardhand
                gameModel.getCardDeck().getCardsFromCardDeck().remove(0); //removes the object at index 0 from the carddeck
                i++;
            }
        }

    }

    /** DONE
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

    /** DONE
     * This method checks the size of the cards that are still in the stack, if this size equals 0, the cards that are not in the game anymore are shuffled and act as new stack (in the old list)
     */
    public void checkCardStackAndShuffle() {
        if (gameModel.getCardDeck().getCardsFromCardDeck().size() == 0) { //checks size
            Collections.shuffle(gameModel.getCardDeck().getPlayedCardsDeck()); //shuffles the cards that are not in the game anymore
            for (int i = 0; i < gameModel.getCardDeck().getPlayedCardsDeck().size(); i++) {
                gameModel.getCardDeck().getCardsFromCardDeck().add(i, gameModel.getCardDeck().getPlayedCardsDeck().get(i)); //adds the cards from the "thrown away"-stack to the regular one
            }
        }
    }

    /** DONE
     * Calculates the score of the player's tiles
     * @param playerID
     * @return Score of a player's tileHand
     */
    public int tileHandScore(int playerID) {
        int score = 0;
        ListIterator<Tile> tileHandIterator = gameModel.getPlayer(playerID).getPlayerTileHand().getTileHand().listIterator();

        while (tileHandIterator.hasNext()) {
            score += tileHandIterator.next().getTileValue();
        }
        return score;
    }

    /** DONE
     * Calculates the player's score of its cards
     * @param playerID
     * @return Score of a player's cardHand
     */
    public int cardHandScore(int playerID) {
        int score = 0;
        ListIterator<Card> cardHandIterator = gameModel.getPlayer(playerID).getPlayerCardHand().getCardHand().listIterator();

        while (cardHandIterator.hasNext()) {
            score++;
        }
        return score;
    }

    /** DONE
     * Calculates the total score of the particular player
     * @param playerID
     * @return player's total score (tileHand + cardHand)
     */
    public int totalScore(int playerID) {
        return cardHandScore(playerID) + tileHandScore(playerID);
    }

    /** DONE
     * This method calculates the winner using the totalScore()-method
     * @return String that contains the winner
     */
    public String winnerCalculation() {
        if (totalScore(1) > totalScore(2)) {
            return "Player 1 won the game!";
        } else if (totalScore(1) < totalScore(2)) {
            return  "Player 2 won the game!";
        } else if (totalScore(1) == totalScore(2)) {
            return "Nice game, you both won!";
        }
        return null;
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
    /*                                              Move Denial Method                                              */
    /*                                                                                                              */
    /****************************************************************************************************************/

    /**
     * This method checks why the move is denied and returns the gameState
     * @param playerID
     * @param card
     * @param figure
     * @return GameState object that contains the necessary information
     */
    public GameState moveDenialMethod(int playerID, Card card, Figure figure) {
        if (isFigureInGame(playerID, figure) == false) {
            gameState.setFigureInGame(false);
            gameState.setOkay(false);
        } else if (isPlayerAbleToPay(playerID, figure, card) == false) {
            gameState.setPlayerAbleToPay(false);
            gameState.setOkay(false);
        }
        return gameState;
    }

    /****************************************************************************************************************/
    /*______________________________________________________________________________________________________________*/
    /*                                                                                                              */
    /*                                           Interface/Jonas' Methods                                           */
    /*          Some of these methods refer to methods that already existed in my GameController when we            */
    /*                     implemented this interface, therefore, not sure if best-practice, but:                   */
    /*                                 if it looks stupid but works, it is not stupid                               */
    /*                                                                                                              */
    /****************************************************************************************************************/

    //TBD? Necessary?
    @Override
    public int start() {
        return 0;
    }

    @Override //DONE
    public List<Tile> getPlayerTiles(int playerId) {
        return gameModel.getPlayer(playerId).getPlayerTileHand().getTileHand();
    }

    @Override //DONE
    public List<Card> getDealedCards(int playerId) {
        return gameModel.getPlayer(playerId).getPlayerCardHand().getCardHand();
    }

    //@Override //DONE
    public int getCardScore(int playerId) {
        return cardHandScore(playerId);
    }

    //@Override //DONE
    public int getTileScore(int playerId) {
        return tileHandScore(playerId);
    }

    @Override //DONE
    public Boolean isMyTurnNow(int playerId) {
        return gameModel.getPlayer(playerId).getMyTurn();
    }

    //Not relevant //DONE
    @Override
    public String sendChatMessage(String sendMessage) {
        return null;
    }

    //Not relevant //DONE
    @Override
    public String receiveChatMessage(String recMessage) {
        return null;
    }

    @Override //DONE
    public List<Tile> getPathTiles() {
        return gameModel.getTileDeck().getTiles();
    }

    //TBD***************************************************************************************************************
    @Override
    public GameState playAnotherCard(int playerId, Card card) {
        return null;
    }

    @Override //DONE
    public GameState move(int playerId, Card card, Figure figureToMove) {
        move(playerId, figureToMove, card);
        return gameState; //would "return null" also work? My move()-method already returns a gameState
    }


}
