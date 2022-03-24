package pt.ipbeja.po2.tictactoe.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipbeja.po2.tictactoe.model.TicTacToeGame;

/**
 * @author Vasco Gomes 19921
 * @date 02/03/2022
 */
public class TicTacToeStart extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final int SIZE = 3;
    @Override
    public void start(Stage primaryStage) {


        TicTacToeGame ticTacToeGame = new TicTacToeGame(SIZE);
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(ticTacToeGame);

        Scene scene = new Scene(ticTacToeBoard);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToe Aula 09/03/2022");
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(400);
        primaryStage.show();
    }
}
