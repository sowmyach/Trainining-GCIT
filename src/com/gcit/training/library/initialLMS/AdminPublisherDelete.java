package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminPublisherDelete {

	public void adminPublisherdelete() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("Select PublisherID from the following list to delete details");			
			PreparedStatement stmt=conn.prepareStatement("Select publisherId, publisherName,publisherAddress,publisherPhone from tbl_publisher");			
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				System.out.println("PublisherId:" + rs.getString(1)+ " ||PublisherName : " + rs.getString(2)+" ||PublisherAddress : " + rs.getString(3)+"|| PublisherPhone : " + rs.getString(4));
				}
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter PublisherId to delete");
			int publisherId=obj.nextInt();							
			
			stmt = conn.prepareStatement("DELETE from tbl_publisher where publisherId=?");	
			  
			stmt.setInt(1, publisherId);
			stmt.executeUpdate();
		       System.out.println("Successfully deleted publisher details"); 
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
