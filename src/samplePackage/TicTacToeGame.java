package samplePackage;

import java.util.Arrays;

public class TicTacToeGame
{
	public static char[] board;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
	}
	
	public static void createBoard()
	{
		board = new char[10];
		Arrays.fill(board, ' ');
	}
}
