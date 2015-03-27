package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminBorrowerAdd {

	public void adminBorrowerAdd() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("||ADD BORROWER DETAILS||");
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter BorrowerName");			
			String borrowerName=obj.next();
			System.out.println("Enter BorrowerAddress");
			String borrowerAddress=obj.next();
			System.out.println("Enter BorrowerPhone");
			String borrowerPhone=obj.next();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_borrower (name,address,phone) VALUES(?,?,?)");
			stmt.setString(1, borrowerName);
			stmt.setString(2, borrowerAddress);
			stmt.setString(3, borrowerPhone);      		
			stmt.executeUpdate();
	       System.out.println("Successfully added details to borrower");  
	       System.out.println("select options...1.Previous menu & 2. Main Admin Menu");
	       int input=obj.nextInt();
	       while(input!=1&&input!=2){
	    	   System.out.println("enter proper input");
	    	   input=obj.nextInt();
	       }
	       if(input==1){
	    	   AdministratorBorrower adminborro=new AdministratorBorrower();
				adminborro.adminBorrower();
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
