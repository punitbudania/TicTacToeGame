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
		firstMove();
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
		char user = sc.next().charAt(0);
		if (user == 'O')
		{
			computer = 'X';
			player = 'O';
		}
		else
		{
			computer = 'O';
			player = 'X';
		}
		System.out.println("player choose: " + player);
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
	
	private static void userMove(char player)  //user's move
	{
		System.out.println("\nSlect an index to make your move");
		Scanner any = new Scanner(System.in);
		int index = any.nextInt();
		if (board[index] == ' ')
		{
			System.out.println("Index is free");
			board[index] = player;
			displayBoard();
			System.out.println("\nComputer's turn");
			computerMove(computer);
		}
		else
		{
			System.out.println("Index is not free");
		}
	}
	
	private static void computerMove(char computer)  // computer's move
	{
		boolean stop = false;
		while(!stop)
		{
			int k = (int) Math.floor(Math.random()*100)%10;
			if(k!=0)
			{	
				if (board[k] == ' ')
				{
					System.out.println("Index is free");
					board[k] = computer;
					displayBoard();
					System.out.println("\nUser's turn");
					stop = true;
					userMove(player);
				}
				else
				{
					System.out.println("Index is not free");
				}
			}
		}
	}
	
	private static void firstMove()    // toss for first move
	{
		int t = (int) Math.floor(Math.random()*10)%2;
		if (t==1)
		{
			System.out.println("\nPlayer will make first move");
			userMove(player);
		}
		else
		{
			System.out.println("\nComputer will make first move");
			computerMove(computer);
		}
	}
}
