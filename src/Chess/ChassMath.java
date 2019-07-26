package Chess;

import BordGame.Board;
import BordGame.Position;
import ChessPiecePa.Hook;
import Pieces.King;

/**
 *
 * @author luizc
 */
public class ChassMath {
    private Board board;
    
    public ChassMath(){
        board = new Board(8, 8);
        initialSetup();
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
    
    private void placeNewPiece(char colomn, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(colomn, row).toPosition());
    }
    private void initialSetup(){
        placeNewPiece('b', 6 ,new Hook(board,Color.WHITE));
        placeNewPiece('e',8,new King(board,Color.BLACK));
        placeNewPiece('e',1,new King(board,Color.WHITE));

    }
}
