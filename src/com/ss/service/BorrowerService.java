package com.ss.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Model.BookLoans;

import java.util.*;

public class BorrowerService {
	
	BorrowerDao borrowrDao = new BorrowerDao();
	List<BookLoans>loansList = new ArrayList<>();
	
	public void checkOutBook(int bookId, int branchId, int cardNo, LocalDateTime obj) {
		try {
			borrowrDao.checkOutBook(bookId, branchId, cardNo,obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkInBook(int cardNo, int bookId, int branchId) {
		try {
			borrowrDao.checkInBook(cardNo, bookId, branchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OpenConnection() {
		try {
			try {
				borrowrDao.openConnection();
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
			count = borrowrDao.readBranch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void readBooks(int branchId) {
		try {
			borrowrDao.readBooks(branchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public boolean checkLoginID(int borrowerCardNo) {
		boolean checkId = false;
		try {
			checkId =  borrowrDao.checkCardNo(borrowerCardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkId;
	}
	
	

}
