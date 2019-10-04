package com.ss.lms.Services;

import com.ss.lms.Dao.AdminDao;
import com.ss.lms.secret.ServerCred;
import com.ss.lms.secret.Url;

import java.io.PrintWriter;
import java.sql.*;

public class AdminServices {
    private Url myUrl = new Url();
    private AdminDao adminDao = new AdminDao();

    public void deleteBook()
    {

    }
    public  void addBook()
    {

    }
    public void updateBook()
    {

    }
    public void deleteBorrower(Integer cardNo)
    {
        try{
         adminDao.deleteBorrower(cardNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower(int cardNo, String name, String address, String phone)
    {
        try{
        adminDao.addBorrower(cardNo,name,address,phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBorrower()
    {

    }



}
