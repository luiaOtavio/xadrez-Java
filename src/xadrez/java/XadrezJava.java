package xadrez.java;

import BordGame.Board;
import Chess.ChassMath;
/**
 *jogo de xadres do curso de java
 * @author luizc
 */
public class XadrezJava {

    public static void main(String[] args) {
        ChassMath chessmath = new ChassMath();
        UI.printBoard(chessmath.getPieces());
        
    }
    
}
