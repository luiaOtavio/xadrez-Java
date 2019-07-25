package BordGame;

/**
 *
 * @author luizc
 */
public class Board {
    private int rows;
    private int colomns;
    private Piece[][] pieces;
    
    public Board(int rows, int colomns){
        this.rows = rows;
        this.colomns = colomns;
        pieces = new Piece[rows][colomns];
    }
    public int getRows(){
        return rows;
    }
    public void setRows(int rows){
        this.rows = rows;
    }
    public int getColumns(){
        return colomns;
    }
    public void setColumns(int colomns){
        this.colomns = colomns;
    }
    public Piece piece(int row, int colomn){
        return pieces[row][colomn];
    }
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
        
    }
}
