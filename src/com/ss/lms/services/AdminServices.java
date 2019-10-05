package com.ss.lms.services;

import com.ss.lms.dao.AdminAuthorDao;
import com.ss.lms.dao.AdminBookDao;
import com.ss.lms.dao.AdminBorrowerDao;
import com.ss.lms.dao.AdminDao;
import com.ss.lms.model.Admin;
import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.Borrower;
import com.ss.lms.secret.Url;

import java.sql.*;

public class AdminServices {
    private Url myUrl = new Url();


    public void deleteBook(Book book)
    {
        try{
            AdminDao<Book> adminDao = new AdminBookDao();
            adminDao.delete(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBook(Book book)
    {
        try{
            AdminDao<Book> adminDao = new AdminBookDao();
            adminDao.add(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook()
    {

    }
    public void deleteBorrower(Borrower borrower)
    {
        try{
         AdminDao<Borrower> adminDao = new AdminBorrowerDao();
         adminDao.delete(borrower);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower(Borrower borrower)
    {
//        try{
//           AdminDao adminDao = new AdminDao();
//           adminDao.addBorrower(
//                borrower.getBorrowerCardNumber(),
//                borrower.getBorrowerName(),
//                borrower.getBorrowerAddress(),
//                borrower.getBorrowerPhoneNumber());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    public void updateBorrower()
    {

    }
    public void addAuthor(Author author)
    {
        try{
            AdminDao<Author> adminDao = new AdminAuthorDao();
            adminDao.add(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor(Author author)
    {
        try{
            AdminDao<Author> adminDao = new AdminAuthorDao();
            adminDao.delete(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
