package pt.ipbeja.po2.tictactoe.tui;

import pt.ipbeja.po2.tictactoe.model.*;

/**
 * @author Vasco Gomes 19921
 * @date 30/03/2022
 */
public class TicTacToeStart{

    private static int SIZE = 3;

    public static void main(String[] args) {

        TicTacToeTUI tui = new TicTacToeTUI(new TicTacToeGame(SIZE));
    }
}
