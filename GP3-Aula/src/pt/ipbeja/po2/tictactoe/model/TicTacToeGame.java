package pt.ipbeja.po2.tictactoe.model;

import java.util.Arrays;

/**
 * @author Vasco Gomes 19921
 * @date 23/03/2022
 */
public class TicTacToeGame {

    //private final int SIZE = 3;
    Mark[][] board;
    View view;
    private int turnCounter;

    public TicTacToeGame(int SIZE){
        initBoard(SIZE);
    }

    public void setView(View view){
        this.view = view;
    }

    private void initBoard(int SIZE) {
        board = new Mark[SIZE][SIZE];
        for (int line = 0; line < SIZE; line++) {
            //Preenche o tabuleiro com Mark.EMPTY
            Arrays.fill(board[line], Mark.EMPTY);
        }
    }

    public Player getCurrentPlayer(){
        return this.turnCounter % 2 == 0 ? Player.X : Player.O;
    }

    public void positionSelected(Position position) {
        //Checks with Player is playing
        if(isValidPlay(position)){
            //TODO realizar a jogada
            board[position.getRow()][position.getCol()] = getCurrentPlayer().getMark();
            turnCounter++;
            view.onBoardMarkChanged(getCurrentPlayer().getMark(), position);

            //Checks if the game is ended after 5 plays
            if(turnCounter >= 5){
                //Checks if a player won
                if(!checkPlayerWon(position)) {
                    //Checks if it draws
                    checkDraw();
                }
            }

        }
    }

    private boolean checkPlayerWon(Position position) {

        //TODO - Verificar os lados e as 2 diagonais
        /*for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != Mark.EMPTY && j == board.length - 1){
                    System.out.println("Cima");
                    break;
                }
            }
        }*/

        /*if(board[0][board.length - 1] != Mark.EMPTY){
            System.out.println("Cima");
        }

        if(board[board.length - 1][0] != Mark.EMPTY){
            System.out.println("Esquerdo");
        }
        if(board[board.length - 1][2] != Mark.EMPTY){
            System.out.println("Direito");
        }
        if(board[2][board.length - 1] != Mark.EMPTY){
            System.out.println("Baixo");
        }*/
        return false;
    }

    private void checkDraw() {
        //Calls View
    }

    private boolean isValidPlay(Position position) {

        if(board[position.getRow()][position.getCol()] == Mark.EMPTY){
            return true;
        }
        return false;
    }

}
