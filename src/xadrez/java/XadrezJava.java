package xadrez.java;

import Chess.ChassMath;
import Chess.ChessException;
import Chess.ChessPiece;
import Chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *jogo de xadres do curso de java
 * @author luizc
 */
public class XadrezJava {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ChassMath chessmath = new ChassMath();
        List<ChessPiece> captured = new ArrayList<>();
        
        while(true){
            try{
                UI.ClearScreen();
                UI.printMatch(chessmath, captured);
                System.out.println("");
                System.out.print("Source:");
                ChessPosition source = UI.readChesPosition(sc);
                
                boolean [][] possibleMove = chessmath.possibleMove(source);
                UI.ClearScreen();
                UI.printBoard(chessmath.getPieces(), possibleMove);
                
                System.out.println("");
                System.out.print("Target:");
                ChessPosition target = UI.readChesPosition(sc);

                ChessPiece capturedPiece = chessmath.performChessMove(source, target);
                
                if(captured != null){
                    captured.add(capturedPiece);
                }
                
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        
        
    }
    
}
