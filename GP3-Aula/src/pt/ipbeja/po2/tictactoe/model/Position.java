package pt.ipbeja.po2.tictactoe.model;

/**
 * @author Vasco Gomes 19921
 * @date 23/03/2022
 */
public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
