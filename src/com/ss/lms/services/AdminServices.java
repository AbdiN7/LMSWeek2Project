package com.ss.lms.services;

import com.ss.lms.dao.AdminDao;
import com.ss.lms.model.Borrower;
import com.ss.lms.secret.Url;

import java.sql.*;

public class AdminServices {
    private Url myUrl = new Url();


    public void deleteBook()
    {

    }
    public  void addBook()
    {

    }
    public void updateBook()
    {

    }
    public void deleteBorrower(Borrower borrower)
    {
        try{
         AdminDao adminDao = new AdminDao();
         adminDao.deleteBorrower(borrower.getBorrowerCardNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower(Borrower borrower)
    {
        try{
           AdminDao adminDao = new AdminDao();
           adminDao.addBorrower(
                borrower.getBorrowerCardNumber(),
                borrower.getBorrowerName(),
                borrower.getBorrowerAddress(),
                borrower.getBorrowerPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBorrower()
    {

    }



}
