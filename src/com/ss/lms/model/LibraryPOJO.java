package com.ss.lms.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryPOJO {

	private int branchId;
	private String branchName;
	private String branchAddress;
	private List<String> bookTitles;
	private List<Integer> noOfCopies;
	
	
	public LibraryPOJO() {
		branchId = 0;
		branchName = "";
		branchAddress = "";
		bookTitles = new ArrayList<>();
		noOfCopies = new ArrayList<>();
	}
	
	public LibraryPOJO(int id, String name, String address, List<String> books, List<Integer> copies) {
		branchId = id;
		branchName = name;
		branchAddress = address;
		bookTitles = books;
		noOfCopies = copies;
	}
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}	
	public List<String> getBookTitles() {
		return bookTitles;
	}
	public void setBookTitles(List<String> books) {
		this.bookTitles = books;
	}	
	public List<Integer> getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int index, int copies) {
		this.noOfCopies.set(index, copies);
	}	
}
