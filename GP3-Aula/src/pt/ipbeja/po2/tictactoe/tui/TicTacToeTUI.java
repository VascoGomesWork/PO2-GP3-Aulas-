package pt.ipbeja.po2.tictactoe.tui;

import pt.ipbeja.po2.tictactoe.model.*;

/**
 * @author Vasco Gomes 19921
 * @date 06/04/2022
 */
public class TicTacToeTUI implements View {

    private String[][] board;
    private final TicTacToeGame game;

    public TicTacToeTUI(TicTacToeGame game) {
        this.game = game;
        this.game.setView(this);
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                System.out.println("__|__|__");
                board[i][j] = "__";
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
