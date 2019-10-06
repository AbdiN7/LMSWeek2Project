package com.ss.test;

import com.ss.lms.dao.DataConnector;
import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.Publisher;
import com.ss.lms.secret.GenerateID;
import com.ss.lms.services.AdminServices;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AdminServicesTest {
    private GenerateID genId = new GenerateID();
    private AdminServices myAdmin = new AdminServices();
    private DataConnector dataConnector = new DataConnector();


    @org.junit.jupiter.api.Test
    void testAuthor() throws SQLException {
        //Creation test
        Connection connection = dataConnector.getCurrConnection();
        Author myAuthor = new Author();
        myAuthor.setAuthorName("James");
        myAuthor.setAuthorId(genId.randomID());
        int authID = myAuthor.getAuthorId();

        myAdmin.addAuthor(myAuthor, connection);
        PreparedStatement st = connection.prepareStatement("Select * from tbl_author");
        ResultSet rs = st.executeQuery();
        String currAuth = "";

        while (rs.next()) {
            currAuth = rs.getString("authorName");
            if (currAuth.equals(myAuthor.getAuthorName())) {
                System.out.println("Author's Initial Name: " + myAuthor.getAuthorName());
            }
        }
        ///Update test
        myAuthor.setAuthorId(authID);
        myAuthor.setAuthorName("Jack");

        myAdmin.updateAuthor(myAuthor, connection);
        PreparedStatement st2 = connection.prepareStatement("Select * from tbl_author");

        ResultSet rs2 = st2.executeQuery();
        while (rs2.next()) {
            currAuth = rs2.getString("authorName");
            if (currAuth.equals(myAuthor.getAuthorName())) {
                System.out.println("Author's Updated Name: " + myAuthor.getAuthorName());
            }

        }
        // Delete Test
        myAuthor.setAuthorId(authID);
        myAdmin.deleteAuthor(myAuthor, connection);

        if (currAuth.equals((myAuthor.getAuthorName()))) {
            fail("Author Not Deleted");
        }
        System.out.println("author Has been Deleted");

    }
}

