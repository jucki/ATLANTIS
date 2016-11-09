package ch.fhnw.atlantis.Server;

/**
 * Created by Tobias on 09.11.2016 (if sth. not written by Tobias, it is mentioned)
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

    public boolean getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public boolean getIsWater() {
        return isWater;
    }

    public int getPaymentValue() {
        return crossingPrice;
    }
}
