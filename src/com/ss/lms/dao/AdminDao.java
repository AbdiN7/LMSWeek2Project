package com.ss.lms.dao;

import com.ss.lms.model.Author;
import com.ss.lms.model.Borrower;
import com.ss.lms.secret.Url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao <T> {
    private Url myUrl = new Url();
    public AdminDao(Borrower borrower)
    {

    }

    public  void deleteBorrower(int cardNo) throws SQLException
    {
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_borrower WHERE cardNo = ? ");
        st.setString(1, String.valueOf(cardNo));
        st.executeUpdate();
        connection.close();
    }
    public  void addBorrower(int cardNo, String name, String address, String phone) throws SQLException
    {
            Connection connection = DriverManager.getConnection(myUrl.getUrl());
            PreparedStatement st = connection.prepareStatement("insert into tbl_borrower (cardNo, name, address, phone)" +
                    "VALUES (?,?,?,?)");
            st.setString(1, String.valueOf(cardNo));
            st.setString(2,name);
            st.setString(3,address);
            st.setString(4,phone);
            st.executeUpdate();
            connection.close();
    }
    public void addAuthor(Author author)
    {

    }
    

}
