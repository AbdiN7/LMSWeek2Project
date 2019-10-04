package com.ss.service;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;

public class BorrowerService {
	
	BorrowerDao borrowrDao = new BorrowerDao();
	
	
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
	
	public void readBranch() {
		try {
			borrowrDao.readBranch();
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
