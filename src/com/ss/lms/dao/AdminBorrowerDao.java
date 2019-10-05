package com.ss.lms.dao;

import com.ss.lms.model.Borrower;
import com.ss.lms.secret.Url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminBorrowerDao implements AdminDao<Borrower> {
    @Override
    public void add(Borrower borrower) throws SQLException {
        Url myUrl = new Url();
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("insert into tbl_borrower (cardNo, name, address, phone)" +
                "VALUES (?,?,?,?)");
        st.setString(1, String.valueOf(borrower.getBorrowerCardNumber()));
        st.setString(2, borrower.getBorrowerName());
        st.setString(3, borrower.getBorrowerAddress());
        st.setString(4, borrower.getBorrowerPhoneNumber());
        st.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(Borrower borrower) throws SQLException {
        Url myUrl = new Url();
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_borrower WHERE cardNo = ? ");
        st.setString(1, String.valueOf(borrower.getBorrowerCardNumber()));
        st.executeUpdate();
        connection.close();
    }
}
