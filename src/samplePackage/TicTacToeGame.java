package samplePackage;

import java.util.Scanner;

public class TicTacToeGame
{
	public static char[] board;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		choice();
	}
	
	public static void createBoard()   //game board created
	{
		board = new char[10];
		for(int i=1; i<10; i++)
		{
			board[i] = ' ';
		}
	}
	
	public static void choice()     // player can choose between x and o.
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose x or o");
		String c = sc.next();
		System.out.println("you choose: " + c);
	}
}
