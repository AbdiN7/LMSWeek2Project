package com.ss.lms.junit;

import com.ss.lms.dao.LibrarianDAO;
import com.ss.lms.model.LibraryBook;
import com.ss.lms.model.LibraryPOJO;
import com.ss.lms.secret.Url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class libraryJUnit {
	private static Url myUrl = new Url();
	private LibrarianDAO testDAO = new LibrarianDAO();
	
	@Test
	public void testAddCopies(){
		try {
			Connection connection = DriverManager.getConnection(myUrl.getUrl());
			int bookId = 5, branchId = 5, newNoOfCopies = 5;
			Boolean none = true;
			testDAO.addCopies(bookId, branchId, newNoOfCopies, none, connection);
			
			PreparedStatement state = connection.prepareStatement("select noOfCopies from tbl_book_copies where bookId = ? and branchId = ?");
			state.setInt(1, bookId);
			state.setInt(2, branchId);
			ResultSet rs = state.executeQuery();
			
			System.out.print(rs.getInt(1) == newNoOfCopies ? "Success" : "Fail");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateCopies(){
		try {
			Connection connection = DriverManager.getConnection(myUrl.getUrl());
			int bookId = 5, branchId = 5, newNoOfCopies = 5;
			Boolean none = false;
			
			PreparedStatement statement = connection.prepareStatement("select noOfCopies from tbl_book_copies where bookId = ? and branchId = ?");
			statement.setInt(1, bookId);
			statement.setInt(2, branchId);
			ResultSet rs = statement.executeQuery();
			int oldCopies = rs.getInt(1);
			
			testDAO.addCopies(bookId, branchId, newNoOfCopies, none, connection);
			
			PreparedStatement state = connection.prepareStatement("select noOfCopies from tbl_book_copies where bookId = ? and branchId = ?");
			state.setInt(1, bookId);
			state.setInt(2, branchId);
			rs = state.executeQuery();
			
			System.out.print(rs.getInt(1) == (oldCopies + newNoOfCopies) ? "Success" : "Fail");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testViewBranches(){
		try {
			List<LibraryPOJO> branches = new ArrayList<>();

			Connection connection = DriverManager.getConnection(myUrl.getUrl());			
			
			branches = testDAO.viewBranches(connection);
			
			PreparedStatement state = connection.prepareStatement("select branchId, branchName from tbl_library_branch");
			ResultSet rs = state.executeQuery();
			
			int count = 0;
			Boolean pass = true;
			while(rs.next()) {
				if(branches.get(count).getBranchId() != rs.getInt(1)) {pass = false;}
				if(!branches.get(count).getBranchName().equals(rs.getString(2))) {pass = false;}
			}
			System.out.println(pass ? "Success" : "Fail");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetBranchInfo(){
		try {
			LibraryPOJO branch = new LibraryPOJO();
			Connection connection = DriverManager.getConnection(myUrl.getUrl());			
			int branchId = 5;
			
			branch = testDAO.getBranchInfo(branchId, connection);
			
			PreparedStatement state = connection.prepareStatement("select branchName, branchAddress from tbl_library_branch where branchId = ?");
			state.setInt(1, branchId);
			ResultSet rs = state.executeQuery();
			
			PreparedStatement statement = connection.prepareStatement("select tbl_book.bookId, title, ifnull(noOfCopies, 0)as noOfCopies\n" + 
					"from tbl_book\n" + 
					"left join (select bookId, noOfCopies from tbl_book_copies where branchId = ?)b\n" + 
					"on tbl_book.bookId=b.bookId");
			statement.setInt(1, branchId);
			ResultSet bookResults = statement.executeQuery();
			
			int count = 0;
			Boolean pass = true;
			if(branch.getBranchId() != (branchId)) {pass = false;}
			if(!branch.getBranchName().equals(rs.getString(1))) {pass = false;}
			if(!branch.getBranchAddress().equals(rs.getString(2))) {pass = false;}
			while(bookResults.next()) {
				LibraryBook book = branch.getBooks().get(count);
				if(book.getBookId() != bookResults.getInt(1)) {pass = false;}
				if(!book.getBookTitle().equals(bookResults.getString(2))) {pass = false;}
				if(book.getNoOfCopies() != bookResults.getInt(3)) {pass = false;}
			}
			
			System.out.println(pass ? "Success" : "Fail");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testUpdateBranches() {
		try {
			Connection connection = DriverManager.getConnection(myUrl.getUrl());
			int branchId = 5;
			String branchName = "", branchAddress = "";
			
			testDAO.updateBranchInfo(branchId, branchName, branchAddress, connection);
			
			PreparedStatement state = connection.prepareStatement("select branchName, branchAddress from tbl_book_copies where branchId = ?");
			state.setInt(1, branchId);
			ResultSet rs = state.executeQuery();
			
			System.out.print(rs.getString(1).equals(branchName) ? "Name: Success" : "Name: Fail");
			System.out.print(rs.getString(2).equals(branchAddress) ? "Address: Success" : "Address: Fail");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}