package com.ss.lms;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;
import com.ss.service.BorrowerService;

public class BorrowerView {
	
	
	
	public void menuBorrower() throws SQLException {
		
		BorrowerService borrowerService = new BorrowerService();
		
		borrowerService.OpenConnection();
		
		char input = 0;
		boolean idFound = false;
		
		while(true) {
			
			Main.ui.borrowerLogIn();
			input = Main.userInput.next().charAt(0);
			Main.ui.borrowerMenuBottom();
			
			if(input == '1') {
				borrowerService.checkLoginID(input);
				if(idFound = true)
				{
					Main.ui.borrowerMenu();
					input = Main.userInput.next().charAt(0);
					Main.ui.borrowerMenuBottom();
				}
				
			}
			else {
				break;
			}
			
			
			
		}
	}

}
