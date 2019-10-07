package com.ss.lms;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ss.lms.Main;
import com.ss.lms.dao.BorrowerDao;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
import com.ss.lms.service.BorrowerService;
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
		LocalDateTime time = LocalDateTime.now();

		while (true) {

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
							idInput = Main.userInput.nextInt();			
							branch = idInput;
							BorrowerService.bookList.clear();
							if(branch!=branchId)
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
									idInput = Main.userInput.nextInt();
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
										}
									}
								}//book check out loop
							}

						} // End of Menu Option 1

					} else if (input == '2') {

						System.out.println("Return a book why don't you");
						count = borrowerService.displayBooks(BorrowerService.borrower.getBorrowerCardNumber());
						int test = Main.userInput.nextInt();
						
						if (count != test) {
							borrowerService.checkInBook(BorrowerService.borrower.getBorrowerCardNumber(),
									BorrowerService.loansList.get(test - 1).getBookId(),
									BorrowerService.loansList.get(test - 1).getBranchId());
							System.out.println(BorrowerService.borrower.getBorrowerCardNumber()+" "+BorrowerService.loansList.get(test-1).getBookId()+" "+BorrowerService.loansList.get(test-1).getBranchId());
							
							
						} else {
							System.out.println(" ");
						}
						borrowerService.killLoans();
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
			borrowerService.destroyList();

		}
		borrowerService.closeConnection();
		borrowerService.destroyList();
		// End of borrower Loop
		System.out.print(ConsoleColors.RESET);
	}

}
