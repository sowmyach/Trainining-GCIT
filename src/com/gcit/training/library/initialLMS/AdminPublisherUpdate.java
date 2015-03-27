package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminPublisherUpdate {

	public void adminPublisherUpdate() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("Select PublisherID from the following list to update details");
			
			PreparedStatement stmt=conn.prepareStatement("Select publisherId, publisherName,publisherAddress,publisherPhone from tbl_publisher");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("publisherId:" + rs.getString(1)+ "||publisherName : " + rs.getString(2)+"||publisherAddress : " + rs.getString(3)+"||publisherPhone : " + rs.getString(4));
				}
			
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter PublisherId");
			int publisherId=obj.nextInt();			
			System.out.println("Enter PublisherName");			
			String publisherName=obj.next();
			System.out.println("Enter PublisherAddress");
			String publisherAddress=obj.next();
			System.out.println("Enter PublisherPhone");
			String publisherPhone=obj.next();
			stmt = conn.prepareStatement("Update tbl_publisher set publisherName=?,PublisherAddress=?, PublisherPhone=? where publisherId=?");
			stmt.setString(1, publisherName);
			stmt.setString(2, publisherAddress);
			stmt.setString(3, publisherPhone);  
			stmt.setInt(4, publisherId);
			stmt.executeUpdate();
	       System.out.println("Successfully updated details of publisher");     	        
	    
		System.out.println("select options...1.Previous menu & 2. Main Admin Menu");
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
