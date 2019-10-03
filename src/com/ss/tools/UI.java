package com.ss.tools;

public class UI {

	public void mainMenuTop() {
		System.out.println("\n");
		System.out.println(ConsoleColors.GREEN_BOLD
				+ " ________________________________________________________________________________");
		System.out.println("|________________________________________________________________________________|");
		System.out.println("| Welcome to the GCIT Libary Management System. Which category of a user are you |");
		System.out.println("|________________________________________________________________________________|");
	}

	public void mainMenuBottom() {
		System.out.println("\n");
		System.out.println(ConsoleColors.GREEN_BOLD
				+ " ________________________________________________________________________________");
	}

	public void mainMenu() {

		System.out.println("|____________________|  __         __    __     ______                           | ");
		System.out.println("|[ 1) Librarian     ]| /\\ \\       /\\ \"-./  \\   /\\  ___\\                          |");
		System.out.println(
				"|                    | \\ \\ \\____  \\ \\ \\-./\\ \\  \\ \\___  \\                         |");
		System.out.println(
				"|[ 2) Administrator ]|  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\/\\_____\\                        |");
		System.out.println("|                    |   \\/_____/   \\/_/  \\/_/   \\/_____/                        |");
		System.out.println("|[ 3) Borrower      ]|                                                           |");
		System.out.println("|                    |                                                           |");
		System.out.println("|[ 0) Quit          ]|                                 Version 0.0.1e (C) 1985   |");
		System.out.println("|____________________|___________________________________________________________|");
		System.out.print("| User Select->"+ ConsoleColors.RESET);
	}

	public void mainMenuQuit() {
		System.out.println(ConsoleColors.GREEN_BOLD+"|Thank you have a day|");
		System.out.println("|Shutting down....   |");
		System.out.println("|____________________|");
	}

	public void menuBoxBottom() {
		System.out.println("|____________________|                                                           |");
	}

	public void menuBoxBottomOffset() {
		System.out.println("                     |____________________|                                      |");
	}

	
	/*
	 * 
	 * Libararian UI block
	 * 
	 * 
	 */
	public void librarianMenu() {
		System.out.print(ConsoleColors.CYAN_BOLD);
		System.out.println("                     |____________________                                       |");
		System.out.println("                     |___Libararian Menu__|                                      |");
		System.out.println("                     |____________________|                                      |");
		System.out.println("                     |[ 1) Enter Branch  ]|                                      |");
		System.out.println("                     |                    |                                      |");
		System.out.println("                     |[ 2) Quite to Prev ]|                                      |");
		System.out.println("                     |____________________|                                      |");
		System.out.print("                     |Input->");
	}
	
	public void librarianBranchMenu() {
		System.out.println("                                          |______________________________________|");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |                                      | ");
		System.out.println("                                          |______________________________________| ");
		System.out.print("                                          |Input->");
	}
	
	public void librarianBranchMenuBottom() {
		System.out.println("\n                                          |______________________________________| "+ConsoleColors.RESET);
	}
    //-----------------------------------------------
	
	
	public void borrowerMenu() {
		System.out.print(ConsoleColors.PURPLE_BOLD);
		System.out.println(" ________________________________________________________________________________");
		System.out.println("|________________________________________________________________________________| ");
		System.out.println("| ______   ______   ______   ______   ______   __     __   ______   ______       |");
		System.out.println("|/\\  == \\ /\\  __ \\ /\\  == \\ /\\  == \\ /\\  __ \\ /\\ \\  _ \\ \\ /\\  ___\\ /\\  == \\      |");
		System.out.println("|\\ \\  __< \\ \\ \\/\\ \\\\ \\  __< \\ \\  __< \\ \\ \\/\\ \\\\ \\ \\/ \".\\ \\\\ \\  __\\ \\ \\  __<      |");
		System.out.println("| \\ \\_____\\\\ \\_____\\\\ \\_\\ \\_\\\\ \\_\\ \\_\\\\ \\_____\\\\ \\__/\".~\\_\\\\ \\_____\\\\ \\_\\ \\_\\    |");
		System.out.println("|  \\/_____/ \\/_____/ \\/_/ /_/ \\/_/ /_/ \\/_____/ \\/_/   \\/_/ \\/_____/ \\/_/ /_/    |");
		System.out.println("|                                                                                |");
		System.out.println("| "+ConsoleColors.BLUE_BACKGROUND_BRIGHT+"[ Enter in your Card ID]"+ConsoleColors.RESET+ConsoleColors.PURPLE_BOLD+"                              Version 0.0.1e (C) 1985  |");
		System.out.println("|________________________________________________________________________________|");
		System.out.print("|#");
	}
	public void borrowerMenuBottom() {
		System.out.println("|________________________________________________________________________________|"+ConsoleColors.RESET);
	}
	
	
	
	
	
	
}
