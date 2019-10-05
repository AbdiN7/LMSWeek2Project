package com.ss.lms.dao;

import com.ss.lms.model.Author;
import com.ss.lms.secret.Url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAuthorDao implements AdminDao<Author> {

    @Override
    public void add(Author author) throws SQLException {
        Url myUrl = new Url();
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("insert into tbl_author (authorId, authorName)" +
                "VALUES (?,?)");
        st.setString(1, String.valueOf(author.getAuthorId()));
        st.setString(2, author.getAuthorName());
        st.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(Author author) throws SQLException {
        Url myUrl = new Url();
        Connection connection = DriverManager.getConnection(myUrl.getUrl());
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_author WHERE authorId = ?");
        st.setString(1, String.valueOf(author.getAuthorId()));
        st.executeUpdate();
        connection.close();
    }
}
