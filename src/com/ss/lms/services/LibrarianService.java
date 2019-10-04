package com.ss.lms.Services;

import java.util.List;
import java.util.Scanner;

import com.ss.lms.Dao.LibrarianDAO;
import com.ss.lms.Model.Book;
import com.ss.lms.Model.LibraryPOJO;

public class LibrarianService {

	public void libraryMain(Scanner scan) {
		while(true) {
			
			System.out.println("1) Enter Branch you manage");
			System.out.println("2) Quit to previous");
			if(validate(2,scan) == 1) {
				libraryTwo(scan);
			}else {
				break;
			}
			
		}
	}
	
	public void libraryTwo(Scanner scan) {
		while(true) {
			int options = 1;
			
			List<String> branches = LibrarianDAO.viewBranches();
			for(String branch : branches) {
				System.out.println(options + ") " + branch);
				options ++;
			}
			System.out.println(options + ") Quit to previous");
			int selection = validate(options, scan);
			if(selection == options) {
				break;
			}else {
				LibraryPOJO branch = LibrarianDAO.getBranchInfo(selection);
				libraryThree(branch,scan);
			}
		}
	}
	
	public void libraryThree(LibraryPOJO branch, Scanner scan) {
option:	while(true) {
			System.out.println("1) Update the details of the library");
			System.out.println("2) Add copies of Book to the Branch");
			System.out.println("3) Quit to previous");
			switch(1) {
			case 1:
				libraryEdit(branch, scan);
				break;
			case 2:
				libraryAddBooks(branch, scan);
				break;
			case 3:
				break option;
			}
		}
	}
	
	public void libraryEdit(LibraryPOJO branch, Scanner scan) {
		
		System.out.println("You have chosen to update the Branch with Branch Id: " + branch.getBranchId() + " and Branch Name: " + branch.getBranchName());
		System.out.println("Enter 'quit' at any prompt to cancel operation.");
		System.out.println();
		System.out.println("Please enter new branch name or enter N/A for no change:");
		String name = scan.nextLine();
		if(name.equalsIgnoreCase("quit")){return;}
		System.out.println("Please enter new branch address or enter N/A for no change:");
		String address = scan.nextLine();
		if(address.equalsIgnoreCase("quit")){return;}
		if(!(name.equalsIgnoreCase("n/a"))){
			branch.setBranchName(name);
		}
		if(!(address.equalsIgnoreCase("n/a"))){
			branch.setBranchAddress(address);
		}
		LibrarianDAO.updateBranchInfo(branch.getBranchId(), branch.getBranchName(), branch.getBranchAddress());
	}
	
	public void libraryAddBooks(LibraryPOJO branch, Scanner scan) {
		int count = 1;
		for(Book book : branch.getBooks()) {
			System.out.println(count + ") " + book.getBookTitle());
			count ++;
		}
		count ++;
		System.out.println(count + ") Cancel");
		int selection = validate((count), scan);
		if(!(selection == count)) {
			selection --;
			int copies = branch.getNoOfCopies(selection);
			System.out.println("Existing number of copies: " + copies);
			System.out.println("Enter number of new copies: ");
			while(!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println("Please enter a number!");
			}
			copies += scan.nextInt();
			branch.setNoOfCopies(selection, copies);
		}
		LibrarianDAO.addCopies(branch.getBooks().get(selection).getBookId(), branch.getBranchId(), branch.getNoOfCopies(selection));
	}
	
	public int validate(int numberOfResponses, Scanner scan){
		while(true){
			while(!scan.hasNextInt()){

				scan.nextLine();
				System.out.println("Please only enter a number!");
			}
			int response = scan.nextInt();
			if(response > 0 && response <= numberOfResponses){
				return response;
			}
			System.out.print("Please only enter 1");
			for(int x = 2; x<numberOfResponses; x++){
			System.out.print(", " + x);
			}	
			System.out.print(" or " + numberOfResponses + "!");
		}
	}
}
