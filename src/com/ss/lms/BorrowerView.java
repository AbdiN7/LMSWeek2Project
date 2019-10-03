package com.ss.lms;

import com.ss.dao.BorrowerDao;
import com.ss.lms.Main;

public class BorrowerView {
	
	
	
	public void menuBorrower() {
		
		BorrowerDao borrowerDao = new BorrowerDao();
		
		borrowerDao.openConnection();
		
		char input = 0;
		
		while(true) {
			
			Main.ui.borrowerMenu();
			input = Main.userInput.next().charAt(0);
			Main.ui.borrowerMenuBottom();
			if(input == '1') {
				
			}
			else {
				break;
			}
			
			
			
		}
	}

}
