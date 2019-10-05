package com.ss.lms.model;

import java.util.ArrayList;
import java.util.List;

import com.ss.lms.model.Book;

public class LibraryPOJO {

	private int branchId;
	private String branchName;
	private String branchAddress;
	private List<Book> books;
	private List<Integer> noOfCopies;
	
	
	public LibraryPOJO() {
		branchId = 0;
		branchName = "";
		branchAddress = "";
		books = new ArrayList<>();
		noOfCopies = new ArrayList<>();
	}
	
	public LibraryPOJO(int id, String name, String address, List<Book> book, List<Integer> copies) {
		branchId = id;
		branchName = name;
		branchAddress = address;
		books = book;
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> book) {
		this.books = book;
	}	
	public int getNoOfCopies(int index) {
		return noOfCopies.get(index);
	}
	public void setNoOfCopies(List<Integer> copies) {
		this.noOfCopies = (copies);
	}	
	public void editNoOfCopies(int index, int copies) {
		this.noOfCopies.set(index, copies);
	}	
}
