package ch.fhnw.atlantis.Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Tobias on 02.11.2016.
 *
 * Instantiates 42 tile objects (6 from each color) and stores them in the ArrayList "TileDeck"
 */
public class TileDeck implements Serializable {


    ArrayList<Tile> PlayedTiles = new ArrayList<Tile>(); //holds the cards that are not in the game anymore;
    ArrayList<Tile> TileDeck = new ArrayList<Tile>();

    int s = 8;
    TileColor tColor;

    /*
     * @param creates the tiledeck
     */
    public void createTileDeck() {
        for (int i = 1; i < s; i++) {                    //do these statements need to go into a method in order to call it when a new game is started or is it fine like that?
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
    }



    /*
     * @param returns the ArrayList that contains the played tiles
     */
    public ArrayList<Tile> getPlayedHands() {
        return PlayedTiles;
    }

    public ArrayList<Tile> getTileDeck() {
        return TileDeck;
    }

}

