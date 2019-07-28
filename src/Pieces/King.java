package Pieces;

import BordGame.Board;
import BordGame.Position;
import Chess.ChessPiece;
import Chess.Color;

/**
 *
 * @author luizc
 */
public class King extends ChessPiece{
    
    public King(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "K ";
    }
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        //above
        p.setValue(position.getRow() -1,position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
                
        //below
        p.setValue(position.getRow() +1,position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //left
        p.setValue(position.getRow() ,position.getColumn() -1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //right
        p.setValue(position.getRow() ,position.getColumn() +1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //Nw
        p.setValue(position.getRow() -1,position.getColumn() -1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //Ne
        p.setValue(position.getRow() -1,position.getColumn() +1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //Sw
        p.setValue(position.getRow() +1,position.getColumn() -1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        //Se
        p.setValue(position.getRow() +1,position.getColumn() +1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;         
        }
        
        
        return mat;
    }
    
}
