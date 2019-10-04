package com.ss.lms.Dao;

import java.util.ArrayList;
import java.util.List;

import com.ss.lms.Model.LibraryPOJO;

public class LibrarianDAO {

	
	public static List<String> viewBranches(){
		List<String> branches = new ArrayList<>();
		//select branchName from tbl_library_branch
		//set to list
		return branches;
	}
	
	public static LibraryPOJO getBranchInfo(int branchId) {
		
		LibraryPOJO branch = new LibraryPOJO();
		
		//connect and find branch by branchId
		//get a list of books and copies in this branch with none = 0
		//add everything to branch
		//select branchName, branchAddress from tbl_library_branch where branchId = branchId
		//select bookName, noOfCopies from tbl_book_copies where branchId = branchId
		//loop through results adding them to 2 lists
		return branch;
	}
	
	public static void updateBranchInfo(int branchId, String branchName, String branchAddress) {
		
		//connect and update name and address at branchId
		
	}
	
	public static void addCopies(int bookId, int branchId, int newNoOfCopies) {
		//connect and update no of copies for bookId at branchId
	}
	
}
