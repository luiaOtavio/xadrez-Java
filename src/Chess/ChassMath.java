package Chess;

import BordGame.Board;
import BordGame.BoardGameException;
import BordGame.Piece;
import BordGame.Position;
import ChessPiecePa.Hook;
import Pieces.King;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizc
 */
public class ChassMath {
    private int turn;
    private Color currentePlaye;
    private List<Piece> pieceOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    
    
    private Board board;
    
    public ChassMath(){
        board = new Board(8, 8);
        turn = 1;
        currentePlaye = Color.WHITE;
        initialSetup();
    }
    public int getTurn(){
        return turn;
    }
    public Color getCurrentePlaye(){
        return currentePlaye;
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
    
    public boolean [][] possibleMove(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    
    public ChessPiece performChessMove(ChessPosition SourcePosition, ChessPosition targetPosition){
        Position source = SourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece)capturedPiece;
    }
    
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        
        if(capturedPiece != null){
            pieceOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
                
                
        board.placePiece(p, target);
        return capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new BoardGameException("Posição não encontrada");
        }
        if(currentePlaye !=((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("a peça escolhida não é sua");
        }
        if(!board.piece(position).isThereAnyPossibleMovie()){
            throw new ChessException("Nõa existe movimento para peça escolhida");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMoves(target)){
            throw new ChessException("A pessa escolhida não pode se move para a posição de destino");
        }
    }
    private void nextTurn(){
        turn++;
        currentePlaye = (currentePlaye == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
    private void placeNewPiece(char colomn, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(colomn, row).toPosition());
        pieceOnTheBoard.add(piece);
    }
    private void initialSetup(){
        placeNewPiece('c', 1, new Hook(board, Color.WHITE));
        placeNewPiece('c', 2, new Hook(board, Color.WHITE));
        placeNewPiece('d', 2, new Hook(board, Color.WHITE));
        placeNewPiece('e', 2, new Hook(board, Color.WHITE));
        placeNewPiece('e', 1, new Hook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Hook(board, Color.BLACK));
        placeNewPiece('c', 8, new Hook(board, Color.BLACK));
        placeNewPiece('d', 7, new Hook(board, Color.BLACK));
        placeNewPiece('e', 7, new Hook(board, Color.BLACK));
        placeNewPiece('e', 8, new Hook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
