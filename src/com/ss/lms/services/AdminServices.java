package com.ss.lms.services;

import com.ss.lms.dao.*;
import com.ss.lms.model.*;

import java.sql.*;
import java.util.Scanner;

public class AdminServices {
    private AdminDao<Book, Connection> bookDao = new AdminBookDao();
    private AdminDao<Borrower, Connection> borrowerDao = new AdminBorrowerDao();
    private AdminDao<Author, Connection> authorDao = new AdminAuthorDao();
    private AdminDao <Publisher, Connection> publisherDao = new AdminPublisherDao();
    private AdminDao<LibraryPOJO, Connection> libDao = new AdminLibBranchDao();

    //////// BOOK SERVICES /////////
    //////// BOOK SERVICES /////////
    //////// BOOK SERVICES /////////
    public void deleteBook(Book book, Connection connection)
    {

        try{
            bookDao.delete(book, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBook(Book book, Connection connection)
    {
        try{
            bookDao.add(book, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook(Book book, Connection connection)
    {
        try{
            bookDao.update(book, connection);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //////// BORROWER SERVICES ////////
    //////// BORROWER SERVICES ////////
    //////// BORROWER SERVICES ////////
    public void deleteBorrower(Borrower borrower, Connection connection)
    {
        try{
         borrowerDao.delete(borrower, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower(Borrower borrower, Connection connection)
    {
        try{
           borrowerDao.add(borrower, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBorrower(Borrower borrower, Connection connection)
    {
        try{
            borrowerDao.update(borrower, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //////// DUE DATE SERVICE /////////
    public void setDueDate(Borrower borrower, Book book, Connection connection)
    {
        try{

            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the Card Number of the user you wish to extend the due date: ");
            borrower.setBorrowerCardNumber(scanner.nextInt());
            System.out.println("Input the Book ID you wish to update the date for: ");
            book.setBookId(scanner.nextInt());
            System.out.println("Input the Year of the Due Date (YYYY): ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Input the month of the New Due Date (MM): ");
            String month = scanner.nextLine();
            System.out.println("Input the Date of the New Due Date (DD):");
            String day = scanner.nextLine();

            String date = (year + month + day);
            AdminDueDate dueDate = new AdminDueDate();
            dueDate.dueDate(borrower,book,connection,date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //////// AUTHOR SERVICES ////////
    //////// AUTHOR SERVICES ////////
    //////// AUTHOR SERVICES ////////
    public void addAuthor(Author author, Connection connection)
    {
        try{
            authorDao.add(author, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor(Author author, Connection connection)
    {
        try{
            authorDao.delete(author, connection);
            author.setAuthorId(null);
            author.setAuthorName(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAuthor(Author author, Connection connection)
    {
        try{
            authorDao.update(author, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //////// PUBLISHER SERVICES ////////
    //////// PUBLISHER SERVICES ////////
    //////// PUBLISHER SERVICES ////////
    public void addPublisher(Publisher publisher, Connection connection)
    {
        try{
            publisherDao.add(publisher , connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deletePublisher(Publisher publisher, Connection connection)
    {
        try{
            publisherDao.delete(publisher, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updatePublisher(Publisher publisher, Connection connection)
    {
        try{
            publisherDao.update(publisher, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //////// LIBRARY BRANCH SERVICES ////////
    //////// LIBRARY BRANCH SERVICES ////////
    //////// LIBRARY BRANCH SERVICES ////////
    public void addLibBranch (LibraryPOJO library, Connection connection)
    {
        try{
            libDao.add(library, connection);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteLibBranch (LibraryPOJO library, Connection connection)
    {
        try
        {
            libDao.delete(library, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateLibBranch (LibraryPOJO library, Connection connection)
    {
        try
        {
            libDao.update(library, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
