package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminPublisherAdd {

	public void adminPublisherAdd() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("||ADD DETAILS TO PUBLISHER||");
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter PublisherName");
			
			String pubName=obj.next();
			System.out.println("Enter PublisherAddress");
			String pubAddress=obj.next();
			System.out.println("Enter PublisherPhone");
			String pubPhone=obj.next();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_publisher (publisherName,publisherAddress,publisherPhone) VALUES(?,?,?)");
			stmt.setString(1, pubName);
			stmt.setString(2, pubAddress);
			stmt.setString(3, pubPhone);      		
			stmt.executeUpdate();
	       System.out.println("Successfully added details to publisher");    
	       System.out.println("select options...1.Previous menu & 2. Main Admin Menu ");
	       int input=obj.nextInt();
		while(input!=1&&input!=2){
	    	   System.out.println("enter proper input");
	    	   input=obj.nextInt();
	       }
	       if(input==1){
	    	   AdministratorPublisher admPub=new AdministratorPublisher();
		 		  admPub.adminPublisher();
	       }
	       else{
	    	   Administrator admin=new Administrator();
	    	   admin.adminMenu();
	       }
		}
	    
		catch (SQLException e)
		{
	        System.out.println("SQL statement is not executed!");
	        e.printStackTrace();
	    }
		
	}

}
