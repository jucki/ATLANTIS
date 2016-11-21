package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;

/**
 * Created by Tobias on 03.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class TileHand {

    private boolean isEmpty;

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


}
