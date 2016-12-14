package ch.fhnw.atlantis.Game.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tobias on 03.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * 30.11.2016 I just realized that this class is not really necessary, such a list could also be created directly in the Player constructor
 */
public class TileHand implements Serializable {

    private static final long serialVersionUID = 122333L;

    private boolean isEmpty;
    private ArrayList<Tile> tile = new ArrayList<Tile>();

    //Constructor
    public TileHand() {
        ArrayList<Tile> tileHand = new ArrayList();
        if (tileHand.size() < 0) {
            isEmpty = true;
        }
        else {
            isEmpty = false;
        }
    }

    /**
     * Defines if tileHand is empty (true) or not (false)
     * @param isEmpty
     */
    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    /**
     * Returns whether the tileHand is empty (true) or not (false)
     * @return isEmpty
     */
    public boolean getIsEmpty() {
        return isEmpty;
    }

    /**
     * Returns the TileHand of the corresponding player
     * @return ArrayList
     */
    public ArrayList<Tile> getTileHand() {
        return tile;
    }


}
