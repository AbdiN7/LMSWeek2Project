package com.ss.lms;

import com.ss.lms.Model.Admin;
import com.ss.lms.Services.AdminServices;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
//        Admin admin = new Admin();

        AdminServices adminServices = new AdminServices();
        adminServices.deleteBorrower(1337);
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/library?user=root&password=admin&serverTimezone=EST5EDT";
//
//        try{
//            Connection con  = DriverManager.getConnection(url);
//            System.out.println("database connected");
//            Statement statement = con.createStatement();
//            String sql = "select * from tbl_borrower";
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next())
//            {
//                System.out.println(rs.getString("name"));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

}
