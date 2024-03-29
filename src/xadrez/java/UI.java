package xadrez.java;

import Chess.ChassMath;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author luizc
 */
public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
    public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static ChessPosition readChesPosition(Scanner sc){
        try{
            String s = sc.nextLine();
            char colomn = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(colomn, row);
        }
        catch(RuntimeException e){
            throw new InputMismatchException("erro lendo posiçõa do xadres: valido somente de a1 a h8");
        }
    }
    public static void printBoard(ChessPiece[][] pieces){
        for(int i=0; i<pieces.length; i++){
            System.out.print((8-i)+" ");
            for(int j=0; j<pieces.length; j++){
                printPiece(pieces[i][j], false);
            }//for j
            System.out.println();
        }//for i
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean backgraund) {
        if(backgraund){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
    	if (piece == null) {
            System.out.print("- " + ANSI_RESET);
        }
        else {
            if (piece.getColor()== Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print("");
    }
    public static void printMatch(ChassMath chessmatch, List<ChessPiece> captured){
        printBoard(chessmatch.getPieces());
        System.out.println("");
        printCapturedPiece(captured);
        System.out.println("");
        System.out.println("Turn: "+chessmatch.getTurn());
        System.out.println("esperando o jogador: "+chessmatch.getCurrentePlaye());
    }
    
    public static void printBoard(ChessPiece[][] pieces, boolean[][]possibleMove){
        for(int i=0; i<pieces.length; i++){
            System.out.print((8-i)+" ");
            for(int j=0; j<pieces.length; j++){
                printPiece(pieces[i][j],possibleMove[i][j]);
            }//for j
            System.out.println();
        }//for i
        System.out.println("  a b c d e f g h");
    }
    private static void printCapturedPiece(List<ChessPiece> captured){
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        System.out.println("peças caputuradas: ");
        System.out.print("white: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);     
        
        System.out.println("peças caputuradas: ");
        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);     
    }

}
