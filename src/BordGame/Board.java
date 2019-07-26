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
        if(rows <1 || colomns < 1){
            throw new BoardGameException("Erro criando o tabuleiro: é necessario ter mais de uma linha e coluna");
        }
        this.rows = rows;
        this.colomns = colomns;
        pieces = new Piece[rows][colomns];
    }
    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return colomns;
    }
    
    public Piece piece(int row, int colomn){
        if(!positionExists(row, colomn)){
            throw new BoardGameException("Erro: Posição não encontrada");
        }
        return pieces[row][colomn];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardGameException("Erro: Posição não encontrada");     
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardGameException("ja tem peça nessa positção "+position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExists(int row, int colomn){       
        return  row >=0 && row< rows && colomn >=0 && colomn< colomns;
    }
            
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardGameException("Erro: Posição não encontrada");     
        }
        return piece(position) !=null;
    }
}
