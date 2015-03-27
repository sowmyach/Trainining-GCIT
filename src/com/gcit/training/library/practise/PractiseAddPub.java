package com.gcit.training.library.practise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class PractiseAddPub {
	public static void main(String[] args) {
		
				try{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	                Statement st = conn.createStatement();
	                System.out.println("Enter the publisher name");
	        		Scanner obj=new Scanner(System.in);
	        		String name=obj.next();
	        		System.out.println("Enter the address ");
	        	    String address=obj.next();
	        		System.out.println("Enter the phone");
	        		String phone=obj.next();
	        		
	        		
	        	st.executeUpdate("INSERT INTO tbl_borrower (name,address,phone) VALUES('"+name+"','"+address+"','"+phone+"')");
	               System.out.println("publisher name is inserted.");
	               System.out.println("address is inserted.");
	               System.out.println("phone is inserted.");
	                
	            }catch (SQLException e){
	                System.out.println("SQL statement is not executed!");
	                e.printStackTrace();
	            }
	        
}
}
