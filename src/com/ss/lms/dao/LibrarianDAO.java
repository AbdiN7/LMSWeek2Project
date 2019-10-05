package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.model.Book;
import com.ss.lms.model.LibraryPOJO;
import com.ss.lms.secret.Url;

public class LibrarianDAO {
	private static Url myUrl = new Url();
	
	public Connection openConnection() throws SQLException{
		return DriverManager.getConnection(myUrl.getUrl());
	}
	public void closeConnection(Connection connection) throws SQLException{
		connection.close();
	}
	
	public List<LibraryPOJO> viewBranches(Connection connection) throws SQLException{
		PreparedStatement state = connection.prepareStatement("select branchId, branchName from tbl_library_branch");
		ResultSet rs = state.executeQuery();
		List<LibraryPOJO> branches = new ArrayList<>();		
		while(rs.next()) {
			LibraryPOJO branch = new LibraryPOJO();
			branch.setBranchId(rs.getInt(1));
			branch.setBranchName(rs.getString(2));
			branches.add(branch);
		}
		connection.close();
		return branches;
	}
	
	public LibraryPOJO getBranchInfo(int branchId, Connection connection) throws SQLException{
		
		PreparedStatement state = connection.prepareStatement("select branchName, branchAddress from tbl_library_branch where branchId = ?");
		state.setString(1, String.valueOf(branchId));
		ResultSet rs = state.executeQuery();
		
		LibraryPOJO branch = new LibraryPOJO();
		branch.setBranchName(rs.getString(1));
		branch.setBranchAddress(rs.getString(2));
		PreparedStatement statement = connection.prepareStatement("select tbl_book.bookId, title, ifnull(noOfCopies, 0)as noOfCopies\n" + 
				"from tbl_book\n" + 
				"left join (select bookId, noOfCopies from tbl_book_copies where branchId = ?)b\n" + 
				"on tbl_book.bookId=b.bookId");
		statement.setString(1, String.valueOf(branchId));
		ResultSet bookResults = statement.executeQuery();
		List<Book> books = new ArrayList<>();
		List<Integer> copies = new ArrayList<>();
		while(bookResults.next()) {
			Book book = new Book();
			book.setBookId(bookResults.getInt(1));
			book.setBookTitle(bookResults.getString(2));
			books.add(book);
			copies.add(bookResults.getInt(3));
		}
		branch.setBooks(books);
		branch.setNoOfCopies(copies);
		return branch;
	}
	
	public void updateBranchInfo(int branchId, String branchName, String branchAddress, Connection connection) throws SQLException{
		PreparedStatement state = connection.prepareStatement("update tbl_library_branch\n" + 
				"set branchName = ?, branchAddress = ?\n" + 
				"where branchId = ?");
		state.setString(1, String.valueOf(branchName));
		state.setString(2, String.valueOf(branchAddress));
		state.setString(3, String.valueOf(branchId));
		state.executeUpdate();
	}
	
	public void addCopies(int bookId, int branchId, int newNoOfCopies, Connection connection) throws SQLException{
		PreparedStatement state = connection.prepareStatement("update tbl_book_copies\n" + 
				"set noOfCopies = ?\n" + 
				"where branchId = ? and bookId = ?");
		state.setString(1, String.valueOf(newNoOfCopies));
		state.setString(2, String.valueOf(branchId));
		state.setString(3, String.valueOf(bookId));
		state.executeUpdate();	
	}
	
}
