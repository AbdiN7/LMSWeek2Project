package com.ss.lms.services;

import com.ss.lms.dao.*;
import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.Borrower;
import com.ss.lms.secret.Url;

import java.sql.*;

public class AdminServices {
    private Url myUrl = new Url();

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
    Connection conn;
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
    public void updateBorrower()
    {

    }
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



}
