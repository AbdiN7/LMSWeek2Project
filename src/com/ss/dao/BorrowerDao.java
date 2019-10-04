package com.ss.dao;

import java.sql.*;

public class BorrowerDao {
	
	Connection connection = null;
	
	
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
	
	public void readBranch() throws SQLException {
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
		System.out.println("|0) Quit to previous                                                             |");
		System.out.println("|________________________________________________________________________________|");
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
