package pt.ipbeja.po2.tictactoe.model;

/**
 * @author Vasco Gomes 19921
 * @date 23/03/2022
 */
public interface View {

    void onBoardMarkChanged(Mark mark, Position position);

    void onGameWon(Player player);

    void onGameDraw();
}
