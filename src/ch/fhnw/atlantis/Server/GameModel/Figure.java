package ch.fhnw.atlantis.Server.GameModel;

/**
 * Created by Tobias on 17.11.2016.
 */
public class Figure {

    private int atIndex;
    private boolean leftAtlantis;
    private boolean reachedMainland;
    private FigureColor color;
    private int figureNumber;

    public Figure(Player player, int figureNumber) {
        this.figureNumber = figureNumber;
        atIndex = -1;
        leftAtlantis = false;
        reachedMainland = false;
        if (player.getPlayerID() == 1) {
            color = FigureColor.SILVER;
        }
        else {
            color = FigureColor.ORANGE;
        }
    }

    /**
     * Returns the index at which the figure is right now
     * @return atIndex
     */
    public int getAtIndex() {
        return atIndex;
    }

    /**
     * Sets the index at which the figure is
     * @param atIndex
     */
    public void setAtIndex(int atIndex) {
        this.atIndex = atIndex;
    }

    /**
     * Returns true if the figure has left atlantis, false otherwise
     * @return leftAtlantis
     */
    public boolean getLeftAtlantis() {
        return leftAtlantis;
    }

    /**
     * Sets if the figure has left atlantis (true) or not (false)
     * @param leftAtlantis
     */
    public void setLeftAtlantis(boolean leftAtlantis) {
        this.leftAtlantis = leftAtlantis;
    }

    /**
     * Returns true if the figure has reached mainland or false otherwise
     * @return reachedMainland
     */
    public boolean getReachedMainland() {
        return reachedMainland;
    }

    /**
     * Sets true if mainland is reached, false otherwise
     * @param reachedMainland
     */
    public void setReachedMainland(boolean reachedMainland) {
        this.reachedMainland = reachedMainland;
    }

    /**
     * Returns false if figure reached mainland and therefore is not in the game anymore
     * @return !reachedMainland
     */
    public boolean isFigureInGame() {
        return !reachedMainland;
    }

    public Figure getFigure(Figure figure) {
        return this;
    }

    public int getFigureNumber() {
        return figureNumber;
    }

}
