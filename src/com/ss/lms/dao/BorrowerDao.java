package com.ss.lms.dao;

import java.sql.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
import com.ss.lms.model.LibraryBranch;
import com.ss.lms.model.Publisher;
import com.ss.lms.service.BorrowerService;

public class BorrowerDao {

	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	/*
	 * 
	 * Open and close the connections when needed
	 * 
	 */
	public void openConnection() throws ClassNotFoundException, SQLException {
		System.out.println("Loading Please Wait.....");
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library?verifyServerCertificate=false&useSSL=true&requireSSL=true", "root",
				"pass");
	}

	public void closeConnection() throws SQLException {
		try {
			System.out.println("Closing Connection to database...");
		} finally {
			connection.close();
			System.out.println("Connection has been closed");
		}
	}
	/*
	 * 
	 * 
	 */

	public List<Book> getBooks(int branchId) throws SQLException {
		stmt = connection
				.prepareStatement("select tbl_book.bookId,tbl_book.title,tbl_book.authId,tbl_author.authorName,\r\n"
						+ "        tbl_book.pubId, tbl_publisher.publisherName,tbl_publisher.publisherAddress,\r\n"
						+ "        tbl_publisher.publisherPhone\r\n" + "from tbl_library_branch \r\n"
						+ "join tbl_book_copies on tbl_library_branch.branchId = tbl_book_copies.branchId\r\n"
						+ "join tbl_book on tbl_book_copies.bookId = tbl_book.bookId\r\n"
						+ "join tbl_author on tbl_book.authId = tbl_author.authorId\r\n"
						+ "join tbl_publisher on tbl_publisher.publisherId = tbl_book.pubId\r\n"
						+ "where tbl_library_branch.branchId = (?);");
		stmt.setInt(1, branchId);
		rs = stmt.executeQuery();
		rs.next();
		do {

			BorrowerService.author = new Author(rs.getInt(3), rs.getString(4));
			BorrowerService.publisher = new Publisher(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
			BorrowerService.book = new Book(rs.getInt(1), rs.getString(2), BorrowerService.author,
					BorrowerService.publisher);
			BorrowerService.bookList.add(BorrowerService.book);
		} while (rs.next());

		return BorrowerService.bookList;
	}

	public Borrower getAccount(int cardNo) throws SQLException {

		stmt = connection.prepareStatement("select * from tbl_borrower where cardNo = (?);");
		stmt.setInt(1, cardNo);
		rs = stmt.executeQuery();
		rs.next();
		BorrowerService.borrower.setBorrowerCardNumber(rs.getInt(1));
		BorrowerService.borrower.setBorrowerName(rs.getString(2));
		BorrowerService.borrower.setBorrowerAddress(rs.getString(3));
		BorrowerService.borrower.setBorrowerPhoneNumber(rs.getString(4));

		return BorrowerService.borrower;
	}

	public List<BookLoans> lonasList() throws SQLException {

		stmt = connection.prepareStatement("select * from tbl_book_loans\r\n" + "where cardNo = ?;");
		stmt.setInt(1, BorrowerService.borrower.getBorrowerCardNumber());
		rs = stmt.executeQuery();
		while (rs.next()) {
			BookLoans bookLoans = new BookLoans(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5));
			BorrowerService.loansList.add(bookLoans);
		}

		return BorrowerService.loansList;
	}

	
	//Disaply the branches that you have in the database
	public int readBranch() throws SQLException {
		int count = 1;
		stmt = connection.prepareStatement("select * from tbl_library_branch");
		rs = stmt.executeQuery();
		System.out.println("|                Pick the Branch you want to check out from                      | ");
		System.out.println("|________________________________________________________________________________|");
		while (rs.next()) {
			System.out.println(String.format("%-20s", "|" + count + ")" + rs.getString(2) + ", " + rs.getString(3)));
			count++;
		}
		System.out.println(
				"|" + count + ") Quit to previous                                                             |");
		System.out.println("|________________________________________________________________________________|");
		return count;
	}

	
	//List of the library branches 
	public List<LibraryBranch> libraryList() throws SQLException {
		stmt = connection.prepareStatement("select * from tbl_library_branch;");
		rs = stmt.executeQuery();

		while (rs.next()) {
			BorrowerService.libraryBranch = new LibraryBranch(rs.getInt(1), rs.getString(2), rs.getString(3));
			BorrowerService.libraryList.add(BorrowerService.libraryBranch);
		}

		return BorrowerService.libraryList;

	}

	
	
	public void selectBranch(int choice) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from tbl_libary_branch");
		ResultSet rs = stmt.executeQuery();

	}

	
	//Check the card No if it's in the database
	public boolean checkCardNo(int borrowerCardNo) throws SQLException {
		System.out.println("Checking ID against our records....");
		PreparedStatement stmt = connection.prepareStatement("select tbl_borrower.cardNo from tbl_borrower");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (rs.getInt(1) == borrowerCardNo) {
				return true;
			}
		}
		return false;

	}

	
	//get the books that are needed to be in the list
	public int readBooks(int branchId) throws SQLException {
		stmt = connection.prepareStatement("Select tbl_book.title, tbl_author.authorName\r\n"
				+ "from tbl_library_branch join tbl_book_copies on tbl_library_branch.branchId = tbl_book_copies.branchId\r\n"
				+ "join tbl_book on tbl_book_copies.bookId = tbl_book.bookId\r\n"
				+ "join tbl_author on tbl_book.authId = tbl_author.authorId\r\n"
				+ "where tbl_library_branch.branchId = (?) and tbl_book_copies.noOfCopies != 0;");
		stmt.setInt(1, branchId);
		rs = stmt.executeQuery();
		int count = 1;
		while (rs.next()) {
			System.out.println("| " + count + ") " + rs.getString(1) + " by " + rs.getString(2));
			count++;
		}
		System.out.println(
				"| " + count + ") Quit to cancel operation                                                  |");
		System.out.println("|________________________________________________________________________________|");
		return count;
	}

	
	//Check out books with this function
	public void checkOutBook(int bookId, int branchId, int cardNo, LocalDateTime obj) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("insert into tbl_book_loans values(?,?,?,?,?);");
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		stmt.setInt(1, bookId);
		stmt.setInt(2, branchId);
		stmt.setInt(3, cardNo);
		stmt.setObject(4, obj.format(myFormatObj));
		stmt.setObject(5, obj.plusDays(7).format(myFormatObj));
		stmt.executeUpdate();

	}

	//Return books with this one
	public void checkInBook(int cardNo, int bookId, int branchId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"delete from tbl_book_loans where tbl_book_loans.cardNo = (?) and tbl_book_loans.bookId = (?)\r\n"
						+ "and tbl_book_loans.branchId = (?);");
		stmt.setInt(1, cardNo);
		stmt.setInt(2, bookId);
		stmt.setInt(3, branchId);
		System.out.println("in");
		stmt.executeUpdate();
		System.out.println("you have retuend book!");

	}

	//Read in the loans of the current user
	public int readLoanBooks(int cardNo) throws SQLException {
		stmt = connection.prepareStatement(
				"select tbl_book.title, tbl_book_loans.dateOut, tbl_book_loans.dueDate from tbl_book_loans\r\n"
						+ "join tbl_book on tbl_book_loans.bookId = tbl_book.bookId\r\n"
						+ "where tbl_book_loans.cardNo = (?);");
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		stmt.setInt(1, cardNo);
		rs = stmt.executeQuery();
		int count = 1;
		while (rs.next()) {
			System.out.println(count + ") " + rs.getString(1) + "    " + rs.getDate(2) + "    " + rs.getDate(3));
			count++;
		}
		System.out.println(count + ") Quit to previous");
		return count;
	}

}
