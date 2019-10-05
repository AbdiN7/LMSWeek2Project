package com.ss.lms.dao;

import com.ss.lms.model.Borrower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AdminBorrowerDao implements AdminDao<Borrower, Connection> {
    private DataConnector dataConnector = new DataConnector();

    @Override
    public void add(Borrower borrower, Connection connection) throws SQLException {
        connection = dataConnector.getCurrConnection();
        PreparedStatement st = connection.prepareStatement("insert into tbl_borrower (cardNo, name, address, phone)" +
                "VALUES (?,?,?,?)");
        st.setString(1, String.valueOf(borrower.getBorrowerCardNumber()));
        st.setString(2, borrower.getBorrowerName());
        st.setString(3, borrower.getBorrowerAddress());
        st.setString(4, borrower.getBorrowerPhoneNumber());
        st.executeUpdate();
    }

    @Override
    public void delete(Borrower borrower, Connection connection) throws SQLException {
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_borrower WHERE cardNo = ? ");
        st.setString(1, String.valueOf(borrower.getBorrowerCardNumber()));
        st.executeUpdate();
    }
}