package com.ss.lms.dao;

import java.util.ArrayList;
import java.util.List;

import com.ss.lms.model.LibraryPOJO;

public class LibrarianDAO {

	
	public List<String> viewBranches(){
		List<String> branches = new ArrayList<>();
		//select branchName from tbl_library_branch
		//set to list
		return branches;
	}
	
	public LibraryPOJO getBranchInfo(int branchId) {
		
		LibraryPOJO branch = new LibraryPOJO();
		
		//connect and find branch by branchId
		//get a list of books and copies in this branch with none = 0
		//add everything to branch
		//select branchName, branchAddress from tbl_library_branch where branchId = branchId
		//select bookName, noOfCopies from tbl_book_copies where branchId = branchId
		//loop through results adding them to 2 lists
		return branch;
	}
	
}
