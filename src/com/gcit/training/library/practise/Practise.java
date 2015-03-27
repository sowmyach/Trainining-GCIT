package com.gcit.training.library.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Practise {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from tbl_author");
					while(rs.next()){
						
						System.out.println("##########");
						System.out.println("AuthorId:"+rs.getInt("authorID"));
						System.out.println("Authorname:"+rs.getString("authorname"));
						System.out.println("##########");
						
					}
					
		
				      stmt = conn.createStatement();
				      System.out.println("Enter the author name");
						Scanner obj=new Scanner(System.in);
						
						String name=obj.nextLine();
				      
				      String sql = "INSERT INTO tbl_author.authorname" +
				                   "VALUES ()";
	
				      stmt.executeUpdate(sql);
				      System.out.println("Inserting records into the table...");
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}

	