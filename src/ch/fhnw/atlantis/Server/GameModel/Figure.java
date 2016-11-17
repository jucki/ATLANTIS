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

    public int getAtIndex() {
        return atIndex;
    }

    public void setAtIndex(int atIndex) {
        this.atIndex = atIndex;
    }

    public boolean getLeftAtlantis() {
        return leftAtlantis;
    }

    public void setLeftAtlantis(boolean leftAtlantis) {
        this.leftAtlantis = leftAtlantis;
    }

    public boolean getReachedMainland() {
        return reachedMainland;
    }

    public void setReachedMainland(boolean reachedMainland) {
        this.reachedMainland = reachedMainland;
    }

}
