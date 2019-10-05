package com.ss.service;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Model.BookLoans;

import java.util.*;

public class BorrowerService {
	
	BorrowerDao borrowrDao = new BorrowerDao();
	List<BookLoans>loansList = new ArrayList<>();
	
	
	public void getInputCheck(int userInput)
	{
		
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
