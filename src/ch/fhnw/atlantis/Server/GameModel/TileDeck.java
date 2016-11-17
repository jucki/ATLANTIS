package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Tobias on 02.11.2016 (if not written by Tobias, it is mentioned)
 *
 * Creates all the ArrayLists for the Tiledeck (relevant tiles), the Watertiles and the played tiles (tiles out of the game)
 * Contains methods that create the tile objects and put them into the respective ArrayList
 */
public class TileDeck {

    ArrayList<Tile> playedTiles = new ArrayList<Tile>(); //holds the cards that are not in the game anymore;
    ArrayList<Tile> tileDeck = new ArrayList<Tile>(); //contains all the 42 tiles that are from relevance (no water)
    ArrayList<WaterTile> waterTileDeck = new ArrayList<WaterTile>(); //stores 42 watertiles

    private int s = 8;

    /**
     * creates ArrayList with all tiles that have a color and a number (no watertiles)
     */
    public void createTileDeck() {
        for (int i = 1; i < s; i++) {
            if (i == 7) { //Black stack has no 7 tile
                break;
            }
            tileDeck.add(new Tile(i, Color.BLACK));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Brown stack has no 6 tile
                i++;
            }
            tileDeck.add(new Tile(i, Color.BROWN));
        }

        for (int i = 1; i < s; i++) {
            if (i == 7) { //White stack has no 7
                break;
            }
            tileDeck.add(new Tile(i, Color.WHITE));
        }

        for (int i = 1; i < s;  i++) {
            if (i == 7) { //Yellow stack has no 7
                break;
            }
            tileDeck.add(new Tile(i, Color.YELLOW));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Green stack has no 6
                i++;
            }
            tileDeck.add(new Tile(i, Color.GREEN));
        }

        for (int i = 1; i < s; i++) {
            if (i == 7) { //Blue stack has no 7
                break;
            }
            tileDeck.add(new Tile(i, Color.BLUE));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Pink stack has no 6
                i++;
            }
            tileDeck.add(new Tile(i, Color.PINK));
        }
        Collections.shuffle(tileDeck);
    }

    /**
     * creates ArrayList with 42 watertiles in it
     */
    public void createWaterTileDeck() {
        for (int i = 1; i <= 42; i++) {
            waterTileDeck.add(new WaterTile());
        }
    }

    /**
     * @return ArrayList that contains the played tiles that are out of the game now
     */
    public ArrayList<Tile> getPlayedHands() {
        return playedTiles;
    }

    /**
     * @return ArrayList that contains the tile deck containing the tiles with colors and numbers
     */
    public ArrayList<Tile> getTileDeck() {
        return tileDeck;
    }

    /**
     * @return ArrayList that contains 42 Watertiles
     */
    public ArrayList<WaterTile> getWaterTileDeck() {
        return waterTileDeck;
    }

    public int getNumberOfTilesInDeck() {
        return tileDeck.size();
    }

    public int getNumberOfPlayedTiles() {
        return playedTiles.size();
    }

    public int getNumberOfWaterTilesInDeck() {
        return waterTileDeck.size();
    }
}
