package com.ss.dao;

import java.sql.*;

public class BorrowerDao {
	
	Connection connection = null;
	
	public void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?verifyServerCertificate=false&useSSL=true&requireSSL=true","root","pass");  
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void closeConnection() throws SQLException {
		try {
			System.out.println("Closing Connection to database...");
		}
		finally {
			connection.close();
			System.out.println("Connection has been closed");
		}
	}

	
	public void getTable() throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		try{  
            Class.forName("com.mysql.jdbc.Driver");  
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","pass");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement(); 
            ResultSet count = stmt.executeQuery("select * from tbl_borrower;");
            //while(count.next())  
            if(count.next()){
            System.out.println(count.getString(1));  
            }
             
            }catch(Exception e){ System.out.println(e);} 
		finally {
			con.close();
		}
	}
	
	
}
