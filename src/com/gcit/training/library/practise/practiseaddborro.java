package com.gcit.training.library.practise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class practiseaddborro {
	public static void main(String[] args) {
		
				try{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	                Statement st = conn.createStatement();
	                System.out.println("Enter the borrower name");
	        		Scanner obj=new Scanner(System.in);
	        		String bname=obj.next();
	        		System.out.println("Enter the address ");
	        	    String add=obj.next();
	        		System.out.println("Enter the phone");
	        		String ph1=obj.next();
	        		
	        		st.executeUpdate("INSERT INTO tbl_borrower (name,address,phone) VALUES('"+bname+"','"+add+"','"+ph1+"')");
	               System.out.println("borrower name is inserted.");
	               System.out.println("address is inserted.");
	               System.out.println("phone is inserted.");
	                
	            }catch (SQLException e){
	                System.out.println("SQL statement is not executed!");
	                e.printStackTrace();
	            }
	        
}
}