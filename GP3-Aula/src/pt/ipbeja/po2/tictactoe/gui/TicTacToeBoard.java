package pt.ipbeja.po2.tictactoe.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import pt.ipbeja.po2.tictactoe.model.*;

/**
 * @author Vasco Gomes 19921
 * @date 09/03/2022
 */
public class TicTacToeBoard extends GridPane implements View {

    private final int SIZE = 3;
    private int counter = 0;
    private TicTacToeGame gameModel;
    private Position position;

    private TicTacToeButton[][] buttons;

    public TicTacToeBoard(TicTacToeGame ticTacToeGame) {
        this.gameModel = ticTacToeGame;
        this.gameModel.setView(this);
        this.buttons = new TicTacToeButton[SIZE][SIZE];
        this.createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //Colocar o botão b no array buttons
                TicTacToeButton ticTacToeButton = new TicTacToeButton(i, j);
                ButtonHandler buttonHandler = new ButtonHandler();
                ticTacToeButton.setOnAction(buttonHandler);
                this.add(ticTacToeButton, j, i);

                //Array de botões inicializado
                this.buttons[i][j] = ticTacToeButton;
            }
        }
    }

    @Override
    public void onBoardMarkChanged(Mark mark, Position position) {
        System.out.println("Row = " + position.getRow());
        System.out.println("Col = " + position.getCol());

        //TODO - Mal Feito
        if(mark.equals(mark.O_MARK)){
            this.buttons[position.getRow()][position.getCol()].setX();
        } else {
            this.buttons[position.getRow()][position.getCol()].setO();
        }

    }

    @Override
    public void onGameWon(Player player) {

    }

    @Override
    public void onGameDraw() {

    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            TicTacToeButton eventSource = (TicTacToeButton) event.getSource();

            gameModel.positionSelected(new Position(eventSource.getRow(), eventSource.getCol()));
        }
    }
}
