package com.gcit.training.library.initialLMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class Returnabook {

	public void Rtnbook(String bwrcardnum) {
		System.out.println("Pick the book you want to return  ");
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			
			PreparedStatement stmt = conn.prepareStatement("select branchid,branchname from tbl_library_branch");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("Branch id:" + rs.getString(1)+ " Branchname : " + rs.getString(2));
				}
			System.out.println("Select the branchid from the list ");	
			Scanner scan = new Scanner(System.in);
			String branch_id = scan.next();
			
			stmt = conn.prepareStatement("select b.bookid,b.title from tbl_book b join tbl_book_loans bl on bl.bookid = b.bookid join tbl_library_branch lb on lb.branchid=bl.branchid where lb.branchid=?");
			stmt.setString(1, branch_id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				System.out.println("bookid: " + rs.getString(1) + "||title:" + rs.getString(2));}
			
			System.out.println("select the bookid you want to return");
			String book_id = scan.next();
			
			 Calendar calendar = Calendar.getInstance();
			    java.sql.Date JavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			    
			
			
			stmt = conn.prepareStatement("update tbl_book_loans set dueDate = ? where bookId = ?");
		
			
			stmt.setDate(1,JavaDateObject );
			stmt.setString(2,book_id);
			
			stmt.executeUpdate();
			
			System.out.println("successfully returned");
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

		
		
	}


