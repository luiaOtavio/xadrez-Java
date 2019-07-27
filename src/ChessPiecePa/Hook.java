
package ChessPiecePa;

import BordGame.Board;
import BordGame.Position;
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
        Position p = new Position(0, 0);
        
        
         //above
        p.setValue(position.getRow() -1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() -1);
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        
        //left
        p.setValue(position.getRow(), position.getColumn() -1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() -1);
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        
        //right
        p.setValue(position.getRow(), position.getColumn() +1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() +1);
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        
        //below
        p.setValue(position.getRow() +1, position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() +1);
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        
        return mat;
    }
}
