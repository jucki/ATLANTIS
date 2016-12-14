package ch.fhnw.atlantis.Game.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tobias Gerhard on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * This class defines the tiles and its methods.
 */
public class Tile implements Serializable {

    private static final long serialVersionUID = 765432L;

    private int tileNumber;
    private int tileValue; //defines the value a tile has which is determined by the number written on the tile
    private boolean tileInGame; //true if the tile is still on the board or in a players hand, false otherwise
    private Color color;
    private boolean isOccupied;
    private boolean isWater;
    private int boardTileIndex; //index of the tile in the ArrayList
    private ArrayList<Tile> tileDeck = new ArrayList<Tile>();

    //Constructor for regular tile
    public Tile(int tileValue, Color color) {
        this.color = color;
        this.tileValue = tileValue;
        isOccupied = false;
        tileInGame = true;
        isWater = false;
        boardTileIndex = tileDeck.indexOf(this); //shows the index at which the tile is
    }

    //Constructor for watertile
    public Tile(boolean isWater) {
        this.isWater = isWater;
    }

    /**
     * Returns the number of the specific tile
     * @return tileNumber
     */
    public int getTileNumber() {
        return tileNumber;
    }

    /**
     * sets the tileNumber (method is pretty useless)
     * @param tileNumber
     */
    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    /**
     * Returns the color of the specific tile
     * @return color
     */
    public Color getTileColor() {
        return color;
    }

    /**
     * Sets the tile's color
     * @param tColor
     */
    public void setTileColor(Color tColor) {
        this.color = color;
    }

    /**
     * Returns a tile's value, which is actually the same as the tileNumber
     * @return tileValue
     */
    public int getTileValue() {
        return tileValue;
    }

    /**
     * sets the value of the tile
     * @param tileValue
     */
    public void setTileValue(int tileValue) {
        this.tileValue = tileValue;
    }

    /**
     * Returns boolean whether a tile is in the game (true) or not anymore (false)
     * @return tileInGame
     */
    public boolean getTileInGame() {
        return tileInGame;
    }

    /**
     * Defines wheter a tile is in the game (true) or not anymore (false)
     * @param tileInGame
     */
    public void setTileInGame(boolean tileInGame) {
        this.tileInGame = tileInGame;
    }

    /**
     * Returns whether a tile is occupied (true) or not (false)
     * @return isOccupied
     */
    public boolean getIsOccupied() {
        return isOccupied;
    }

    /**
     * Sets the boolean attribute isOccupied to true if a tile is occupied by a figure, false if it is free
     * @param isOccupied
     */
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * Attribute that defines that this tile is not water, always returns false
     * @return isWater
     */
    public boolean getIsWater() {
        return isWater;
    }

    public int getBoardTileIndex() {
        return boardTileIndex;
    }

}
