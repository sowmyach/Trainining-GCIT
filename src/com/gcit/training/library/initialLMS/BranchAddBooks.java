package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BranchAddBooks {

	public void add_books (String brhid) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			
			PreparedStatement stmt = conn.prepareStatement("select tbc.bookid,tb.title,tbc.noofcopies from tbl_book_copies tbc join tbl_book tb on tbc.bookid=tb.bookid where branchid=?");
			stmt.setString(1, brhid);
			ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			System.out.println("Bookid: "+ rs.getString(1)+ "||Title: " + rs.getString(2) +" ||Existing Noofcopies are: "+ rs.getString(3));
			
			}
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Pick the bookId to add to existing copies");
		String bookid=obj.next();
		System.out.println("How many copies to be added?");
		int newnoofcopies=obj.nextInt();
		if(newnoofcopies==0){
			System.out.println("Not valid entry,Enter new number of copies");
			newnoofcopies=obj.nextInt();
				
		}
		else{
			stmt = conn.prepareStatement("Update tbl_book_copies set newnoofcopies=?  where bookid=?");
			stmt.setInt(1, newnoofcopies);
			stmt.setString(2, bookid);
			
			stmt.executeUpdate();
			System.out.println("Update Successfull!!");
			branchmenu br = new branchmenu();
			br.brmenu();
		}
		
		}
				
		catch (SQLException e){
		    System.out.println("SQL statement is not executed!");
		    e.printStackTrace();
		}
		
	}

	
}
