package samplePackage;

import java.util.Scanner;

public class TicTacToeGame
{
	private static char[] board;
	private static char player;
	private static char computer;
	static int total = 0;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe Game");
		gamePlay();
		
		boolean again = false;
		while(!again)
		{
			System.out.println("Press 1 to play again");
			System.out.println("Press 0 to quit");
			int check = input.nextInt();
			
			if(check==1)
			{
				total=0;
				gamePlay();
			}
			else
			{
				again = true;
			}
		}
	}
	
	
	public static void gamePlay()
	{
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
	
	
	
	private static void userMove()  //user's move
	{
		if (total==9)
		{
			System.out.println("It's a tie");
		}
		else
		{
			total++;
			int y = 0;
			boolean found = false;
			while(!found)
			{
				System.out.println("\nSlect an index to make your move");
				Scanner any = new Scanner(System.in);
				int index = any.nextInt();
				if (board[index] == ' ')
				{
					System.out.println("Index is free");
					board[index] = player;
					displayBoard();
					if(winningCondition(player)==true)
					{
						System.out.println("\nPlayer Won");
						found = true;
					}
					else
					{
						System.out.println("\nComputer's turn");
						computerMove();
						found = true;
					}
				}
				else
				{
					System.out.println("Index is not free");
				}
			}
		}
	}
	
	
	
	private static void computerMove()  // computer's move
	{
		if (total==9)
		{
			System.out.println("It's a tie");
		}
		else
		{	
			total++;
			boolean stop = false;
			int z = 0;
			int t = 0;
			while(!stop)
			{
				
				for (int a=1; a<10; a++)
				{
					if(board[a]==' ')
					{
						board[a] = computer;
						if(winningCondition(computer)==true)
						{
							board[a] = computer;
							displayBoard();
							System.out.println("\nComputer Won");
							z=1;
							stop = true;
							break;
						}
						else
						{
							board[a]=' ';
						}
					}
				}
				stop = true;
			}
			
			if(z==0)
			{
				boolean know = false;
				while(!know)
				{
					for (int r=1; r<10; r++)
					{
						if(board[r]==' ')
						{
							board[r] = player;
							if(winningCondition(player)==true)
							{
								board[r] = computer;
								displayBoard();
								System.out.println("\nUser's turn");
								t=1;
								userMove();
								know = true;
								break;
							}
							else
							{
								board[r]=' ';
							}
						}
					}
					know = true;
				}	
			}
				
			if(t==0 && z==0)
			{	
					boolean let = false;
					while(!let)
					{
						if(board[1]==' ') 
						{
							board[1]=computer;
							displayBoard();
							System.out.println("\nUser's turn");
							userMove();
							let = true;
						}
						else if(board[3]==' ')
						{
							board[3]=computer;
							displayBoard();
							System.out.println("\nUser's turn");
							userMove();
							let = true;
						}
						else if(board[7]==' ')
						{
							board[7]=computer;
							displayBoard();
							System.out.println("\nUser's turn");
							userMove();
							let = true;
						}
						else if(board[9]==' ')
						{
							board[9]=computer;
							displayBoard();
							System.out.println("\nUser's turn");
							userMove();
							let = true;
						}
						else if(board[5]==' ')
						{
							board[5]=computer;
							displayBoard();
							System.out.println("\nUser's turn");
							userMove();
							let = true;
						}
						else
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
									userMove();
									let = true;
								}
								else
								{
									System.out.println("Index is not free");
								}
							}
						}	
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
			userMove();
		}
		else
		{
			System.out.println("\nComputer will make first move");
			computerMove();
		}
	}
	
	
	
	private static boolean winningCondition(char ch)     // winning condition for players
	{
		return((board[1] == ch && board[2] == ch && board[3] == ch)
				|| (board[4] == ch && board[5] == ch && board[6] == ch)
				|| (board[7] == ch && board[8] == ch && board[9] == ch)
				|| (board[1] == ch && board[4] == ch && board[7] == ch)
				|| (board[2] == ch && board[5] == ch && board[8] == ch)
				|| (board[3] == ch && board[6] == ch && board[9] == ch)
				|| (board[1] == ch && board[5] == ch && board[9] == ch)
				|| (board[7] == ch && board[5] == ch && board[3] == ch));
	}
}
