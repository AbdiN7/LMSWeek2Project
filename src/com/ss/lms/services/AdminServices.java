package com.ss.lms.services;

import com.ss.lms.dao.*;
import com.ss.lms.model.*;

import java.sql.*;
import java.util.Scanner;

public class AdminServices {

    //////// BOOK SERVICES /////////
    //////// BOOK SERVICES /////////
    //////// BOOK SERVICES /////////
    public void deleteBook(Book book, Connection connection)
    {

        try{
            AdminDao<Book, Connection> adminDao = new AdminBookDao();
            adminDao.delete(book, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBook(Book book, Connection connection)
    {
        try{
            AdminDao<Book, Connection> adminDao = new AdminBookDao();
            adminDao.add(book, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook()
    {

    }
    //////// BORROWER SERVICES ////////
    //////// BORROWER SERVICES ////////
    //////// BORROWER SERVICES ////////
    public void deleteBorrower(Borrower borrower, Connection connection)
    {
        try{
         AdminDao<Borrower, Connection> adminDao = new AdminBorrowerDao();
         adminDao.delete(borrower, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower(Borrower borrower, Connection connection)
    {
        try{
           AdminDao<Borrower, Connection> adminDao = new AdminBorrowerDao();
           adminDao.add(borrower, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBorrower(Borrower borrower, Connection connection)
    {
        try{
            AdminDao<Borrower, Connection> adminDao = new AdminBorrowerDao();
            adminDao.update(borrower, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

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
            AdminDao<Author, Connection> adminDao = new AdminAuthorDao();
            adminDao.add(author, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor(Author author, Connection connection)
    {
        try{
            AdminDao<Author, Connection> adminDao = new AdminAuthorDao();
            adminDao.delete(author, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAuthor(Author author, Connection connection)
    {
        try{
            AdminDao<Author, Connection> adminDao = new AdminAuthorDao();
            adminDao.update(author, connection);
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
            AdminDao <Publisher, Connection> adminDao = new AdminPublisherDao();
            adminDao.add(publisher , connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deletePublisher(Publisher publisher, Connection connection)
    {
        try{
            AdminDao<Publisher, Connection> adminDao = new AdminPublisherDao();
            adminDao.delete(publisher, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updatePublisher(Publisher publisher, Connection connection)
    {
        try{
            AdminDao<Publisher, Connection> adminDao = new AdminPublisherDao();
            adminDao.update(publisher, connection);
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
            AdminDao<LibraryPOJO, Connection> adminDao = new AdminLibBranchDao();
            adminDao.add(library, connection);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteLibBranch (LibraryPOJO library, Connection connection)
    {
        try
        {
            AdminDao<LibraryPOJO, Connection> adminDao = new AdminLibBranchDao();
            adminDao.delete(library, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateLibBranch (LibraryPOJO library, Connection connection)
    {
        try
        {
            AdminDao<LibraryPOJO, Connection> adminDao = new AdminLibBranchDao();
            adminDao.update(library, connection);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
