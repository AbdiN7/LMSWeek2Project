package com.ss.lms;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

import com.ss.lms.Main;
import com.ss.lms.services.BorrowerService;
import com.ss.tools.ConsoleColors;

public class BorrowerView {

	public void menuBorrower() throws SQLException {

		BorrowerService borrowerService = new BorrowerService();

		borrowerService.OpenConnection();
		char input = 0;
		boolean idFound = false;
		int idInput = 0;
		int branch = 0;
		int count = 0;
		int logInAttempts = 10;
		LocalDateTime time = LocalDateTime.now();
		
		//Start of borrower loop
		while (true) {

			//Check the id and login
			Main.ui.borrowerLogIn();
			idInput = Main.userInput.nextInt();
			Main.ui.borrowerMenuBottom();
			borrowerService.getLibrary();
			idFound = borrowerService.checkLoginID(idInput);
			
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
							try {
								idInput = Main.userInput.nextInt();
							} catch (InputMismatchException e) {
								System.out.println("Not a valid input!");
							}
							branch = idInput;
							BorrowerService.bookList.clear();
							if (branch != branchId)
								borrowerService.getBooks(BorrowerService.libraryList.get(branch - 1).getBranchId());
							if (idInput == branchId) {
								borrowerService.destroyList();
								borrowerService.getLoans();
								borrowerService.getLibrary();
								break;
							} else if (idInput != branchId) {
								while (true) {
									int bookChoice = borrowerService
											.readBooks(BorrowerService.libraryList.get(branch - 1).getBranchId());
									try {
										idInput = Main.userInput.nextInt();
									} catch (InputMismatchException e) {
										System.out.println("Not a valid input!");
									}
									if (idInput == bookChoice) {
										break;
									} else if (idInput != bookChoice) {
										if (borrowerService.alreadyCheckedOut(idInput)) {
											System.out.println("Were sorry you have this book checked out already :(");
										} else {
											borrowerService.checkOutBook(
													BorrowerService.bookList.get(idInput - 1).getBookId(),
													BorrowerService.libraryList.get(branch - 1).getBranchId(),
													BorrowerService.borrower.getBorrowerCardNumber(), time);
											System.out.println("You just checked out "
													+ BorrowerService.bookList.get(idInput - 1).getBookTitle() + "!");
											borrowerService.removeReturnCopie(
													BorrowerService.bookList.get(idInput - 1).getBookId());
										}
									}
								} // book check out loop
							}

						} // End of Menu Option 1

					} else if (input == '2') {

						System.out.println("Return a book why don't you");
						count = borrowerService.displayBooks(BorrowerService.borrower.getBorrowerCardNumber());
						int index = 0;
						try {
							index = Main.userInput.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Not a valid input!");
						}

						if (count != index) {
							borrowerService.checkInBook(BorrowerService.borrower.getBorrowerCardNumber(),
									BorrowerService.loansList.get(index - 1).getBookId(),
									BorrowerService.loansList.get(index - 1).getBranchId());
							System.out.println(BorrowerService.borrower.getBorrowerCardNumber() + " "
									+ BorrowerService.loansList.get(index - 1).getBookId() + " "
									+ BorrowerService.loansList.get(index - 1).getBranchId());
							borrowerService.addReturnCopie(BorrowerService.loansList.get(index - 1).getBookId());

						} else {
							System.out.println(" ");
						}
						borrowerService.destroyOnlyLoans();
						borrowerService.getLoans();

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
			logInAttempts--;
			if (logInAttempts == 0) {
				break;
			} else {
				System.out.println("You have " + logInAttempts + " Login attempts left!");
			}
			borrowerService.destroyList();

		}
		borrowerService.closeConnection();
		borrowerService.destroyList();
		// End of borrower Loop
		System.out.print(ConsoleColors.RESET);
	}

}
