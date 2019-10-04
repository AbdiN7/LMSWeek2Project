package com.ss.service;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;

public class BorrowerService {
	
	BorrowerDao borrowrDao = new BorrowerDao();
	
	
	public void OpenConnection() {
		borrowrDao.openConnection();
	}
	
	public void checkLoginID(int borrowerCardNo) {
		try {
			borrowrDao.checkCardNo(borrowerCardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
