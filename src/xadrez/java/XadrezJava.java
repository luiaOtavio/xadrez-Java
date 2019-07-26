package xadrez.java;

import Chess.ChassMath;
import Chess.ChessException;
import Chess.ChessPiece;
import Chess.ChessPosition;
import java.util.InputMismatchException;
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
            try{
                //UI.ClearScreen();
                UI.printBoard(chessmath.getPieces());
                System.out.println("");
                System.out.print("Source:");
                ChessPosition source = UI.readChesPosition(sc);

                System.out.println("");
                System.out.print("Target:");
                ChessPosition target = UI.readChesPosition(sc);

                ChessPiece capturedPiece = chessmath.performChessMove(source, target);
                UI.ClearScreen();

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
