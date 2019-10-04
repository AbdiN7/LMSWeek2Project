package com.ss.lms;

import java.sql.SQLException;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;
import com.ss.service.BorrowerService;

public class BorrowerView {
	
	
	
	public void menuBorrower() throws SQLException {
		
		BorrowerService bs = new BorrowerService();
		
		bs.OpenConnection();
		
		char input = 0;
		boolean fuck = false;
		while(true) {
			
			Main.ui.borrowerMenu();
			input = Main.userInput.next().charAt(0);
			Main.ui.borrowerMenuBottom();
			if(input == '1') {
				bs.checkLoginID(input);
				if(fuck = true)
				{
					System.out.println("fuck");
				}
				
			}
			else {
				break;
			}
			
			
			
		}
	}

}
