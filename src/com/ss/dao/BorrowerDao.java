package com.ss.dao;

import java.sql.*;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class BorrowerDao {
	
	Connection connection = null;
	
	
	/*
	 * 
	 * Open and close the connections when needed
	 * 
	 */
	public void openConnection() throws ClassNotFoundException, SQLException {
			System.out.println("Loading Please Wait.....");
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?verifyServerCertificate=false&useSSL=true&requireSSL=true","root","pass");  
	}
	
	public void closeConnection() throws SQLException {
		try {
			System.out.println("Closing Connection to database...");
		}
		finally {
			connection.close();
			System.out.println("Connection has been closed");
		}
	}
	/*
	 * 
	 * 
	 */
	
	
	public int readBranch() throws SQLException {
		int count = 1;
		PreparedStatement  stmt = connection.prepareStatement("select * from tbl_library_branch");
		ResultSet rs = stmt.executeQuery();
		System.out.println("|                Pick the Branch you want to check out from                      | ");
		System.out.println("|________________________________________________________________________________|");
		while(rs.next())
		{
			System.out.println(String.format("%-20s","|"+count+")"+rs.getString(2)+", "+rs.getString(3)));
			count++;
		}
		System.out.println("|"+count+") Quit to previous                                                             |");
		System.out.println("|________________________________________________________________________________|");
		return count;
	}
	
	public void selectBranch(int choice) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from tbl_libary_branch");
		ResultSet rs = stmt.executeQuery();
		
	}
	
	
	public boolean checkCardNo(int borrowerCardNo) throws SQLException {
		System.out.println("Checking ID against our records....");
		PreparedStatement  stmt = connection.prepareStatement("select tbl_borrower.cardNo from tbl_borrower");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			if(rs.getInt(1) == borrowerCardNo) {
				return true;
			}
		}
		return  false;
		
	}
	
	public void readBooks(int branchId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("Select tbl_book.title, tbl_author.authorName\r\n" + 
				"from tbl_library_branch join tbl_book_copies on tbl_library_branch.branchId = tbl_book_copies.branchId\r\n" + 
				"join tbl_book on tbl_book_copies.bookId = tbl_book.bookId\r\n" + 
				"join tbl_author on tbl_book.authId = tbl_author.authorId\r\n" + 
				"where tbl_library_branch.branchId = (?) and tbl_book_copies.noOfCopies != 0;");
		ResultSet rs = null;
		stmt.setInt(1,branchId);
		rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+ " by " + rs.getString(2));
		}	
	}
	
	public void checkOutBook(int bookId, int branchId, int cardNo,LocalDateTime obj  ) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("insert into tbl_book_loans values(?,?,?,?,?);");
		ResultSet rs = null;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		stmt.setInt(1, bookId);
		stmt.setInt(2, branchId);
		stmt.setInt(3, cardNo);
		stmt.setObject(4, obj.format(myFormatObj));
		stmt.setObject(5, obj.plusDays(7).format(myFormatObj));
		stmt.executeUpdate();
		
	}
	
	
	public void checkInBook(int cardNo, int bookId, int branchId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from tbl_book_loans where tbl_book_loans.cardNo = ? and tbl_book_loans.bookId = ?\r\n" + 
				                                             "and tbl_book_loans.branchId = ?;");
		ResultSet rs = null;
		stmt.setInt(1, cardNo);
		stmt.setInt(2, bookId);
		stmt.setInt(3, branchId);
		stmt.executeUpdate();
		System.out.println("you have retuend book!");
		
	}
	
	


	
	
	
	
	
	
	
}
