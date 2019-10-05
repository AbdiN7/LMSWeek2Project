package com.ss.lms.dao;

import com.ss.lms.model.Book;
import com.ss.lms.secret.Url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminBookDao implements AdminDao<Book> {
    private Url myUrl = new Url();
    @Override
    public void add(Book book) throws SQLException {
        int authId = book.getBookAuthor().getAuthorId();
        int pubId = book.getBookPublisher().getPublisherId();
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("insert into tbl_book (bookId,title,authId,pubId) "+
                "VALUES (?,?,?,?)");
        st.setString(1, String.valueOf(book.getBookId()));
        st.setString(2,book.getBookTitle());
        st.setString(3,String.valueOf(authId));
        st.setString(4,String.valueOf(pubId));
        st.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(Book book) throws SQLException {
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_book WHERE bookId = ?");
        st.setString(1,String.valueOf(book.getBookId()));
        st.executeUpdate();
        connection.close();
    }
}
