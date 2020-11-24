package samplePackage;

import java.util.Scanner;

public class TicTacToeGame
{
	private static char[] board;
	private static char player;
	private static char computer;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		choice();
	}
	
	private static void createBoard()   //game board created
	{
		board = new char[10];
		for(int i=1; i<10; i++)
		{
			board[i] = ' ';
		}
	}
	
	private static void choice()     // player can choose between x and o.
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose x or o");
		char player = sc.next().charAt(0);
		if (player == 'o')
		{
			computer = 'x';
		}
		else
		{
			computer = 'o';
		}
		System.out.println("player choose: " + player);
	}
}
