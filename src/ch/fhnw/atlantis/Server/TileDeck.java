package ch.fhnw.atlantis.Server;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Tobias on 02.11.2016 (if not written by Tobias, it is mentioned)
 *
 * Creates all the ArrayLists for the Tiledeck (relevant tiles), the Watertiles and the played tiles (tiles out of the game)
 * Contains methods that create the tile objects and put them into the respective ArrayList
 */
public class TileDeck {

    ArrayList<Tile> PlayedTiles = new ArrayList<Tile>(); //holds the cards that are not in the game anymore;
    ArrayList<Tile> TileDeck = new ArrayList<Tile>(); //contains all the 42 tiles that are from relevance (no water)
    ArrayList<WaterTile> WaterTileDeck = new ArrayList<WaterTile>(); //stores 42 watertiles

    private int s = 8;

    /**
     * @return ArrayList with all tiles that have a color and a number (no watertiles)
     */
    public ArrayList<Tile> createTileDeck() {
        for (int i = 1; i < s; i++) {
            if (i == 7) { //Black stack has no 7 tile
                break;
            }
            TileDeck.add(new Tile(i, TileColor.BLACK));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Brown stack has no 6 tile
                i++;
            }
            TileDeck.add(new Tile(i, TileColor.BROWN));
        }

        for (int i = 1; i < s; i++) {
            if (i == 7) { //White stack has no 7
                break;
            }
            TileDeck.add(new Tile(i, TileColor.WHITE));
        }

        for (int i = 1; i < s;  i++) {
            if (i == 7) { //Yellow stack has no 7
                break;
            }
            TileDeck.add(new Tile(i, TileColor.YELLOW));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Green stack has no 6
                i++;
            }
            TileDeck.add(new Tile(i, TileColor.GREEN));
        }

        for (int i = 1; i < s; i++) {
            if (i == 7) { //Blue stack has no 7
                break;
            }
            TileDeck.add(new Tile(i, TileColor.BLUE));
        }

        for (int i = 1; i < s; i++) {
            if (i == 6) { //Pink stack has no 6
                i++;
            }
            TileDeck.add(new Tile(i, TileColor.PINK));
        }
        Collections.shuffle(TileDeck);
        return TileDeck;
    }

    /**
     * @return ArrayList that contains 42 watertiles
     */
    public ArrayList<WaterTile> createWaterTileDeck() {
        for (int i = 1; i <= 42; i++) {
            WaterTileDeck.add(new WaterTile());
            i++;
        }
        return WaterTileDeck;
    }

    /**
     * @return ArrayList that contains the played tiles that are out of the game now
     */
    public ArrayList<Tile> getPlayedHands() {
        return PlayedTiles;
    }

    /**
     * @return ArrayList that contains the tile deck containing the tiles with colors and numbers
     */
    public ArrayList<Tile> getTileDeck() {
        return TileDeck;
    }

    /**
     * @return ArrayList that contains 42 Watertiles
     */
    public ArrayList<WaterTile> getWaterTileDeck() {
        return WaterTileDeck;
    }

}
