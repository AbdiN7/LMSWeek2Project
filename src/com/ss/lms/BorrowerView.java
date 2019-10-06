package com.ss.lms;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
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
		int branch = 0;
		LocalDateTime time = LocalDateTime.now();

		while (true) {

			// borrowerService.checkInBook(467, 1, 1);

			// borrowerService.checkOutBook(1, 1, 467, obj);
			// borrowerService.getBooks(1);

			Main.ui.borrowerLogIn();
			idInput = Main.userInput.nextInt();
			Main.ui.borrowerMenuBottom();
			borrowerService.getLibrary();
			idFound = borrowerService.checkLoginID(idInput);
			System.out.println(idFound);
			if (idFound) {
				borrowerService.getAccount(idInput);
				borrowerService.getLoans();
				while (true) {
					Main.ui.borrowerMenu();
					input = Main.userInput.next().charAt(0);
					Main.ui.borrowerMenuBottom();

					if (input == '1') {
						while (true) {
							Main.ui.borrowerMenuOne();
							int branchId = borrowerService.readBranch();
							Main.ui.borrowerMenuOneBottome();
							idInput = Main.userInput.nextInt();

							if (idInput == branchId) {
								break;
							} else if (idInput != branchId) {
								while (true) {
									branchId = idInput;
									borrowerService
											.getBooks(BorrowerService.libraryList.get(idInput - 1).getBranchId());
									int bookChoice = borrowerService
											.readBooks(BorrowerService.libraryList.get(idInput - 1).getBranchId());
									idInput = Main.userInput.nextInt();
									if (idInput == bookChoice) {
										break;
									} else if (idInput != bookChoice) {
										System.out.println(BorrowerService.bookList.size());
										if (borrowerService.alreadyCheckedOut(idInput)) {
											System.out.println("Were sorry you have this book checked out already :(");
										} else {
											borrowerService.checkOutBook(
													BorrowerService.bookList.get(idInput - 1).getBookId(),
													BorrowerService.libraryList.get(branchId - 1).getBranchId(),
													BorrowerService.borrower.getBorrowerCardNumber(), time);
											System.out.println("You just checked out "
													+ BorrowerService.bookList.get(idInput - 1).getBookTitle() + "!");
										}
									}
								}

							}

						} // End of Menu Option 1

					} else if (input == '2') {

						System.out.println("Return a book why don't you");
						BorrowerService.loansList.forEach(n -> System.out.println());
						int test = Main.userInput.nextInt();
						borrowerService.checkInBook(BorrowerService.borrower.getBorrowerCardNumber(),
								BorrowerService.loansList.get(test - 1).getBookId(),
								BorrowerService.libraryList.get(0).getBranchId());

					} else if (input == '3') {
						idInput = -1;
						break;
					} else {
						System.out.println("Not a valid menu option!");
					}

				} // End of Borrower Menu

			} else {
				System.out.println("Re-Enter a Valid ID");
			}
			if (idInput == -1) {
				break;
			}

		}
		borrowerService.closeConnection();
		borrowerService.destroyList();
		// End of borrower Loop
		System.out.print(ConsoleColors.RESET);
	}

}
