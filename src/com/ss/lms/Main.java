package com.ss.lms;

import com.ss.dao.*;
import com.ss.lms.model.Borrower;
import com.ss.lms.services.AdminServices;
import com.ss.tools.*;

import java.sql.SQLException;
import java.util.Scanner;



public class Main {
	

	
	static UI ui = new UI();
	static BorrowerView borrowerView = new BorrowerView();

	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)  {


		char input = ' ';

		ui.mainMenuTop();

		while (true) {

			ui.mainMenu();

			input = userInput.next().charAt(0);

			ui.menuBoxBottom();

			if (input == '1') {

			} else if (input == '2') {

			} else if (input == '3') {
				borrowerView.menuBorrower();

			} else if (input == '0') {
				break;
			} else {
				System.out.println("Not a choice!");
			}

			ui.mainMenuBottom();

		}
		ui.mainMenuQuit();
		userInput.close();
	}
}
