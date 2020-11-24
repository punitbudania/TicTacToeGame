package samplePackage;

import java.util.Scanner;

public class Choice 
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Choose x or o");
	String c = sc.next();
	System.out.println("your choose: " + c);
	}
}
