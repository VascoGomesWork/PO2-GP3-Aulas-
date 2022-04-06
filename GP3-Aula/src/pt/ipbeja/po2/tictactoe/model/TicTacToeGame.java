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
    private int positionCounter = 0;

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
            view.onBoardMarkChanged(getCurrentPlayer().getMark(), position);
            turnCounter++;

            //Checks if the game is ended after 5 plays
            if(turnCounter >= board.length * 2 - 1){
                //Checks if a player won
                if(!checkPlayerWon(position)) {
                    //Checks if it draws
                    if(checkDraw()) view.onGameDraw();
                }
                view.onGameWon(getCurrentPlayer());
            }

        }
    }

    private boolean checkPlayerWon(Position position) {

        //TODO - Verificar os lados e as 2 diagonais

        //Lines and Columns
        if(checkRow(position) || checkCol(position) || checkDiagonal(position) || checkAntiDiagonal(position)){
            System.out.println("Linha ou Coluna toda preenchida");
            return true;
        }
        return false;
    }

    private boolean checkRow(Position position){

        for (int j = 0; j < board.length - 1; j++) {
            Mark a = board[position.getRow()][j];
            Mark b = board[position.getRow()][j + 1];
            if(a != b) return false;
        }
        return true;
    }

    private boolean checkCol(Position position){

        for (int i = 0; i < board.length - 1; i++) {
            Mark a = board[i][position.getCol()];
            Mark b = board[i + 1][position.getCol()];
            if(a != b) return false;
        }
        return true;
    }

    private boolean checkDiagonal(Position position){
        if(position.getRow() != position.getCol()) return false;

            for (int i = 0; i < board.length - 1; i++) {
                Mark a = board[i][i];
                Mark b = board[i + 1][i + 1];
                if (a != b) return false;
            }
            return true;
    }

    /* 0 + 2 = 2
       1 + 1 = 2
       2 + 0 = 2
     */
    private boolean checkAntiDiagonal(Position position){
        if(position.getRow() + position.getCol() != board.length - 1) return false;

        for (int i = 0; i < board.length - 1; i++) {
            int j = (board.length - 1) - i;
            Mark a = board[i][j];
            Mark b = board[i + 1][j - 1];
            if (a != b) return false;
        }
        return true;
    }

    private boolean checkDraw() {
        //Calls View
        if(turnCounter == board.length * board.length){
            return true;
        }
        return false;
    }

    /*private boolean checkRow(Position position){

        Mark[] boardLine = board[position.getRow()];

        for (int i = 1; i < board.length; i++) {
            if(boardLine[0].equals(boardLine[i])){
                System.out.println("Linha Igual = " + boardLine[i]);
                positionCounter++;
                if(positionCounter == boardLine.length){
                    System.out.println("TUDO IGUAL");
                    return true;
                }
            }
        }
        return false;
    }*/

    private boolean isValidPlay(Position position) {

        if(board[position.getRow()][position.getCol()] == Mark.EMPTY){
            return true;
        }
        return false;
    }

}
