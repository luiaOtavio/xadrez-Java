package xadrez.java;

import Chess.ChassMath;
import Chess.ChessPiece;
import Chess.ChessPosition;
import java.util.Scanner;
/**
 *jogo de xadres do curso de java
 * @author luizc
 */
public class XadrezJava {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ChassMath chessmath = new ChassMath();
        
        while(true){
            UI.printBoard(chessmath.getPieces());
            System.out.println("");
            System.out.print("Source:");
            ChessPosition source = UI.readChesPosition(sc);
            
            System.out.println("");
            System.out.print("Target:");
            ChessPosition target = UI.readChesPosition(sc);
            
            ChessPiece capturedPiece = chessmath.performChessMove(source, target);
        }
        
        
    }
    
}
