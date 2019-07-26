
package ChessPiecePa;

import BordGame.Board;
import Chess.ChessPiece;
import Chess.Color;

/**
 *
 * @author luizc
 */
public class Hook extends ChessPiece{
    
    public Hook(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "R ";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
