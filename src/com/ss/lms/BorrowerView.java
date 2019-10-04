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
			int ainput = Main.userInput.nextInt();
			Main.ui.borrowerMenuBottom();
			
			if(input == '1') {
				borrowerService.checkLoginID(ainput);
				if(idFound = true)
				{
					Main.ui.borrowerMenu();
					borrowerService.readBranch();
					Main.userInput.next();
					input = Main.userInput.next().charAt(0);
					
					if(input == '1') {
						Main.ui.borrowerMenuBottom();
					}
				}
				
			}
			else if( input == '0') {
				break;
			}
			else
			{
				System.out.println("Re-Enter a Valid ID");
			}
			
			
			
		}
	}

}
