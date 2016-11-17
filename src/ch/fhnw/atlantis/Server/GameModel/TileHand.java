package ch.fhnw.atlantis.Server.GameModel;

import java.util.ArrayList;

/**
 * Created by Tobias on 03.11.2016 (if sth. not written by Tobias, it is mentioned)
 */
public class TileHand {

    private boolean isEmpty;

    public TileHand() {
        ArrayList<Tile> tileHand = new ArrayList();
        if (tileHand.size() < 0) {
            isEmpty = true;
        }
        else {
            isEmpty = false;
        }
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }


}
