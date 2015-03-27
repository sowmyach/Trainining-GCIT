package com.gcit.training.library.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class practise_addauthor {
	public static void main(String[] args) {
		
				try{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	                Statement st = conn.createStatement();
	                System.out.println("Enter the author name");
	        		Scanner obj=new Scanner(System.in);
	        		String auth=obj.next();
	        		
	        		st.executeUpdate("INSERT INTO tbl_author (authorname) VALUES('"+auth+"')");
	               System.out.println("author name is inserted.");
	                
	            }catch (SQLException e){
	                System.out.println("SQL statement is not executed!");
	                e.printStackTrace();
	            }
	        
}
}