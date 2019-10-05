package com.ss.lms.dao;

import com.ss.lms.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAuthorDao implements AdminDao<Author, Connection > {

    private DataConnector dataConnector = new DataConnector();

    @Override
    public void add(Author author, Connection connection) throws SQLException {

        connection = dataConnector.getCurrConnection();
        PreparedStatement st = connection.prepareStatement("insert into tbl_author (authorId, authorName)" +
                "VALUES (?,?)");
        st.setString(1, String.valueOf(author.getAuthorId()));
        st.setString(2, author.getAuthorName());
        st.executeUpdate();
    }

    @Override
    public void delete(Author author, Connection connection)  throws SQLException {
        connection = dataConnector.getCurrConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM tbl_author WHERE authorId = ?");
        st.setString(1, String.valueOf(author.getAuthorId()));
        st.executeUpdate();
        connection.close();
    }
}
