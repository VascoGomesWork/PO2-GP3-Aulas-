package pt.ipbeja.po2.tictactoe.gui;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pt.ipbeja.po2.tictactoe.model.Mark;

/**
 * @author Vasco Gomes 19921
 * @date 16/03/2022
 */
public class TicTacToeButton extends Button {

    private int row;
    private int col;

    public TicTacToeButton(int row, int col){
        this.row = row;
        this.col = col;
        this.setGraphic(new ImageView("resources/noplayer.png"));
    }

    public void setX() {
        this.setGraphic(new ImageView("resources/player1.png"));
        this.setDisable(true);
    }

    public void setO() {
        this.setGraphic(new ImageView("resources/player2.png"));
        this.setDisable(true);
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public void setMark(Mark mark) {
        switch (mark){

            case EMPTY:{
                this.setGraphic(new ImageView("resources/noplayer.png"));
            }
                break;
            case X_MARK:{
                setO();
            }
                break;
            case O_MARK:{
                setX();
            }
                break;
        }
    }
}
