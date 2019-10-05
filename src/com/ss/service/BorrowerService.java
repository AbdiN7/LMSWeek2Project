package com.ss.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Model.Author;
import com.ss.lms.Model.Book;
import com.ss.lms.Model.BookLoans;
import com.ss.lms.Model.Borrower;
import com.ss.lms.Model.Publisher;

import java.util.*;

public class BorrowerService {
	
	BorrowerDao borrowerDao = new BorrowerDao();
	public static List<BookLoans>loansList = new ArrayList<BookLoans>();
	public static List<Book>bookList = new ArrayList<Book>();
	public static Borrower borrower = new Borrower();
	public static Publisher publisher = new Publisher();
	public static Author author = new Author();
	public static Book book = new Book();
	
	public void getAccount(int cardNo) {
		
		borrower.setBorrowerCardNumber(cardNo);
		try {
			borrower = borrowerDao.getAccount(cardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * System.out.println(borrower.getBorrowerCardNumber() +
		 * borrower.getBorrowerName()+ borrower.getBorrowerAddress()+
		 * borrower.getBorrowerPhoneNumber());
		 */
	}
	
	public void getLoans(){
		
		try {
			loansList = borrowerDao.lonasList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//loansList.forEach(n->System.out.println(n.getDateOut()));
		
	}
	
	public void getBooks(int branchId) {
		try {
			bookList = borrowerDao.getBooks(branchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//bookList.forEach(n->System.out.println(n.getBookTitle()));
	}
	
	
	
	public void checkOutBook(int bookId, int branchId, int cardNo, LocalDateTime obj) {
		try {
			borrowerDao.checkOutBook(bookId, branchId, cardNo,obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkInBook(int cardNo, int bookId, int branchId) {
		try {
			borrowerDao.checkInBook(cardNo, bookId, branchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OpenConnection() {
		try {
			try {
				borrowerDao.openConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int readBranch() {
		int count = 0;
		try {
			count = borrowerDao.readBranch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int readBooks(int branchId) {
		int count = 0;
		try {
			count  = borrowerDao.readBooks(branchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Borrower borrower() {
		
		
		
		return borrower;
	}
	
	
	
	public boolean checkLoginID(int borrowerCardNo) {
		boolean checkId = false;
		try {
			checkId =  borrowerDao.checkCardNo(borrowerCardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkId;
	}
	
	

}
