package com.ss.lms;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;
import com.ss.lms.Model.BookLoans;
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
		LocalDateTime obj = LocalDateTime.now();

		while (true) {
			
			//borrowerService.checkInBook(467, 1, 1);
			
			//borrowerService.checkOutBook(1, 1, 467, obj);
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
						int getNum = borrowerService.readBranch();
						Main.ui.borrowerMenuOneBottome();
						idInput = Main.userInput.nextInt();
						if(idInput == getNum) {
							break;
						}
						else {
							borrowerService.readBooks(idInput);
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
