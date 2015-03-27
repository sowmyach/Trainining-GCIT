package com.gcit.training.library.initialLMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminAddAuthor {

	public void adminAddAuthor() {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			
			System.out.println("Enter BookId");
			Scanner obj=new Scanner(System.in);
			int bookId=obj.nextInt();
			System.out.println("Enter the title");
			String bookTitle=obj.next();
			System.out.println("Enter PublisherId");
			int pubId=obj.nextInt();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_book (bookId,title,pubId) VALUES(?,?,?)");
			stmt.setInt(1, bookId);
			stmt.setString(2, bookTitle);
			stmt.setInt(3, pubId);
            		
    		stmt.executeUpdate();
           System.out.println("update successfull.");
            
        }catch (SQLException e){
            System.out.println("SQL statement is not executed!");
            e.printStackTrace();
        }
    
}
		
	}


