package com.ss.lms.Services;

import com.ss.lms.secret.ServerCred;

import java.sql.*;

public class AdminServices {

    private String getUrl()
    {
        ServerCred mySecret = new ServerCred();
        return ("jdbc:mysql://localhost:3306/library?" + "user=" +
                mySecret.getServerUser() + "&password="+
                mySecret.getServerPWord()+"&serverTimezone=EST5EDT");
    }
    public void deleteBook()
    {

    }
    public  void addBook()
    {

    }
    public void updateBook()
    {

    }

    //////////////
//    public void listBorrowers()

    public void deleteBorrower(Integer cardNo)
    {
        try{
            Connection connection = DriverManager.getConnection(getUrl());
            PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_borrower WHERE cardNo = ? ");
            st.setString(1, String.valueOf(cardNo));
            st.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void addBorrower()
    {

    }
    public void updateBorrower()
    {

    }



}
