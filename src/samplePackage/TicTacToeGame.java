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
		displayBoard();
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
		System.out.println("Choose X or O");
		char player = sc.next().charAt(0);
		if (player == 'O')
		{
			computer = 'X';
		}
		else
		{
			computer = 'O';
		}
		System.out.println("player choose: " + player);
	}
	
	private static void displayBoard()  //displaying board
	{
		for (int j=1; j<10; j++)
		{
			if (j%3 == 0 && j<9)
			{
				System.out.print(" [" + j + "]");
				System.out.println("\n-----|-----|----");
			}
			else if (j==9)
			{
				System.out.print(" [" + j + "]");
			}
			else
			{
				System.out.print(" [" + j + "] |");
			}
		}
	}
}
