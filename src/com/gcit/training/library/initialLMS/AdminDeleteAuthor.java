package com.gcit.training.library.initialLMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class AdminDeleteAuthor {

	public void adminDeleteAuthor() {
		try{
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			
			PreparedStatement stmt = conn.prepareStatement("select authorid,authorname from tbl_author");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				System.out.println("Author id:" +rs.getString(1) + " ||Authorname: " +rs.getString(2));
			}
			
			System.out.println("select the book id you want to delete");
			Scanner scan = new Scanner(System.in);
			String authorid = scan.next();
			
			stmt = conn.prepareStatement("delete from tbl_author where authorid=?");
			stmt.setString(1, authorid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
