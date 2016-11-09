package ch.fhnw.atlantis.Server;

import java.io.Serializable;

/**
 * Created by Tobias Gerhard on 02.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * This class defines the tiles and its methods.
 */
public class Tile implements Serializable {

    private int tileNumber;
    private int tileValue; //defines the value a tile has which is determined by the number written on the tile
    private boolean tileInGame; //true if the tile is still on the board or in a players hand, false otherwise
    private TileColor tColor;
    private boolean isOccupied;


    public Tile(int tileValue, TileColor tColor) {
        this.tColor = tColor;
        this.tileValue = tileValue;
        boolean isOccupied = false;
        boolean tileInGame = true;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public TileColor getTileColor() {
        return tColor;
    }

    public void setTileColor(TileColor tColor) {
        this.tColor = tColor;
    }

    public int getTileValue() {
        return tileValue;
    }

    public void setTileValue(int tileValue) {
        this.tileValue = tileValue;
    }

    public boolean getTileInGame() {
        return tileInGame;
    }

    public void setTileInGame(boolean tileInGame) {
        this.tileInGame = tileInGame;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

}
