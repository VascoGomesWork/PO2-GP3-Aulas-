package pt.ipbeja.po2.tictactoe.tui;

import pt.ipbeja.po2.tictactoe.gui.TicTacToeBoard;
import pt.ipbeja.po2.tictactoe.model.*;

/**
 * @author Vasco Gomes 19921
 * @date 30/03/2022
 */
public class TicTacToeTui implements View {

    private static int SIZE;

    public static void main(String[] args) {

        showBoard();
        //new TicTacToeGame(SIZE);
    }

    private static void showBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.println("|___|___|");
            }
        }
    }

    @Override
    public void onBoardMarkChanged(Mark mark, Position position) {

    }

    @Override
    public void onGameWon(Player player) {

    }

    @Override
    public void onGameDraw() {

    }
}
