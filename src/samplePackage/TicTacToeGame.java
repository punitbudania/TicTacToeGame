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
		
		//char player = choice();
		//displayBoard();
		firstMove();
		//userMove(player);
	}
	
	private static void createBoard()   //game board created
	{
		board = new char[10];
		for(int i=1; i<10; i++)
		{
			board[i] = ' ';
		}
	}
	
	private static char choice()     // player can choose between x and o.
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
		return player;
	}
	
	private static void displayBoard()  //displaying board
	{
		for (int j=1; j<10; j++)
		{
			if (j%3 == 0 && j<9)
			{
				System.out.print("  " + board[j] +" ");
				System.out.println("\n-----|-----|-----");
			}
			else if (j==9)
			{
				System.out.print("  " +board[j]+ " ");
			}
			else
			{
				System.out.print("  " + board[j] + "  |");
			}
		}
	}
	
	private static void userMove(char player)  //user's first move
	{
		System.out.println("\nSlect an index to make your move");
		Scanner any = new Scanner(System.in);
		int index = any.nextInt();
		if (board[index] == ' ')
		{
			System.out.println("Index is free");
			board[index] = player;
			displayBoard();
		}
		else
		{
			System.out.println("Index is not free");
		}
	}
	
	private static void firstMove()
	{
		int t = (int) Math.floor(Math.random()*10)%2;
		if (t==1)
		{
			System.out.println("\nPlayer will make first move");
		}
		else
		{
			System.out.println("\nComputer will make first move");
		}
	}
}
