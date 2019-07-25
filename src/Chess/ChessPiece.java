package Chess;

import BordGame.Board;
import BordGame.Piece;

/**
 *
 * @author luizc
 */
public class ChessPiece extends Piece{
    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }
    public Color getColor(Color color){
        return color;
    }
    
    
}
