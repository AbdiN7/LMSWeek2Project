package com.ss.lms;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;
import com.ss.service.BorrowerService;
import com.ss.tools.ConsoleColors;

public class BorrowerView {

	public void menuBorrower() throws SQLException {

		BorrowerService borrowerService = new BorrowerService();

		borrowerService.OpenConnection();
		// ok
		char input = 0;
		boolean idFound = false;
		int idInput = 0;

		while (true) {

			Main.ui.borrowerLogIn();
			idInput = Main.userInput.nextInt();
			Main.ui.borrowerMenuBottom();

			idFound = borrowerService.checkLoginID(idInput);
			System.out.println(idFound);
			if (idFound) {
				while (true) {
					Main.ui.borrowerMenu();
					input = Main.userInput.next().charAt(0);
					Main.ui.borrowerMenuBottom();

					if (input == '1') {
						while(true) {
						Main.ui.borrowerMenuOne();
						borrowerService.readBranch();
						Main.ui.borrowerMenuOneBottome();
						input = Main.userInput.next().charAt(0);
						
						if(input == '0') {
							break;
						}
						}
					} else if (input == '2') {

					} else if (input == '3') {
						idInput = -1;
						break;
					} else {
						System.out.println("Not a valid menu option!");
					}
				}
			} else {
				System.out.println("Re-Enter a Valid ID");
			}
			if (idInput == -1) {
				break;
			}

		}
		//End of borrower Loop
		System.out.print(ConsoleColors.RESET);
	}

}
