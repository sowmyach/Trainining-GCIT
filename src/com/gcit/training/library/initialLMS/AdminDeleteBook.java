package com.gcit.training.library.initialLMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class AdminDeleteBook {

	public void adminDeleteBook() {
		try{
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			
			PreparedStatement stmt = conn.prepareStatement("select bookid,title from tbl_book");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				System.out.println("Book id:" +rs.getString(1) + " ||title: " +rs.getString(2));
			}
			
			System.out.println("select the book id you want to delete");
			Scanner scan = new Scanner(System.in);
			String bookid = scan.next();
			
			stmt = conn.prepareStatement("delete from tbl_book where bookid=?");
			stmt.setString(1, bookid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	
		

}
