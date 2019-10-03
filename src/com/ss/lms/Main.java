package com.ss.lms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int input = 0;

		System.out.println("\n");
		System.out.println(" ________________________________________________________________________________");
		System.out.println("|________________________________________________________________________________|");
		System.out.println("| Welcome to the GCIT Libary Management System. Which category of a user are you |");
		System.out.println("|________________________________________________________________________________|");

		while (true) {
			System.out.println("|____________________|  __         __    __     ______                           | ");
			System.out.println("|[ 1) Librarian     ]| /\\ \\       /\\ \"-./  \\   /\\  ___\\                          |");
			System.out.println("|                    | \\ \\ \\____  \\ \\ \\-./\\ \\  \\ \\___  \\                         |");
			System.out.println("|[ 2) Administrator ]|  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\/\\_____\\                        |");
			System.out.println("|                    |   \\/_____/   \\/_/  \\/_/   \\/_____/                        |");
			System.out.println("|[ 3) Borrower      ]|                                                           |");
			System.out.println("|                    |                                                           |");
			System.out.println("|[ 0) Quit          ]|                                 Version 0.0.1e (C) 1985   |");
			System.out.println("|____________________|___________________________________________________________|");
			System.out.print("| User Select->");

			try {
				input = userInput.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not the right format");
			}
			System.out.println("|____________________|");

			
			if (input == 1) {
				System.out.println("                     |____________________|");
				System.out.println("                     |[ 1) Enter Branch  ]|");
				System.out.println("                     |                    |");
				System.out.println("                     |[ 2) Quite to Prev ]|");
				System.out.println("                     |____________________|");
				System.out.print("                     |Input->");
				try {
					input = userInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Not the right format");
				}
				System.out.println("|____________________|");
				
			} else if (input == 2) {

			} else if (input == 3) {

			} else if (input == 0) {
				break;
			} else {
				System.out.println("Not a choice!");
			}

		}
		System.out.println("|Thank you have a day|");
		System.out.println("|Shutting down....   |");
		System.out.println("|____________________|");
    }
}
