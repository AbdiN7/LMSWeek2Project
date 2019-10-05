package com.ss.dao;

import java.sql.*;

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
	
	

	
	/*
	 * public void getTable() throws SQLException, ClassNotFoundException {
	 * 
	 * Connection con = null; try{ Class.forName("com.mysql.jdbc.Driver");
	 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root",
	 * "pass"); //here sonoo is database name, root is username and password
	 * Statement stmt=con.createStatement(); ResultSet count =
	 * stmt.executeQuery("select * from tbl_borrower;"); //while(count.next())
	 * if(count.next()){ System.out.println(count.getString(1)); }
	 * 
	 * }catch(Exception e){ System.out.println(e);} finally { con.close(); } }
	 */
	
	
}
