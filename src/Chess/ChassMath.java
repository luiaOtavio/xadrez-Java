package Chess;

import BordGame.Board;

/**
 *
 * @author luizc
 */
public class ChassMath {
    private Board board;
    
    public ChassMath(){
        board = new Board(8, 8);
    }
    public ChessPiece[][]getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i=0; i<board.getRows(); i++){
            for(int j=0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece)board.piece(i, j);                
            }//for j
        }//for i
        return mat;
    }//Chesspiece
    
}
