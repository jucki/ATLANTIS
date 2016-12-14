package ch.fhnw.atlantis.Game.Model;

/**
 * Created by Tobias on 09.11.2016 (if sth. not written by Tobias, it is mentioned)
 *
 * 5.12. I just realized that this class is unneccessary and causes troubles
 */
public class WaterTile {

    private boolean onBoard; //true if on board, false otherwise
    private final boolean isWater; //always true
    private final int crossingPrice; //always 1

    public WaterTile() {
        onBoard = false;
        isWater = true;
        crossingPrice = 1;
    }

    /**
     * Returns true if this tile is on board, false otherwies
     * @return onBoard
     */
    public boolean getOnBoard() {
        return onBoard;
    }

    /**
     * Sets true if the tile is on board, false otherwise
     * @param onBoard
     */
    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    /**
     * Returns the isWater attribute, which is always true (maybe this method is not necessary)
     * @return
     */
    public boolean getIsWater() {
        return isWater;
    }

    /**
     * Returns the crossingPrice of a waterTile, which is always 1
     * @return crossingPrice
     */
    public int getPaymentValue() {
        return crossingPrice;
    }
}
