package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminBorrowerUpdate {

	public void adminBorrowerUpdate() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("Select BorrowerID from the following list to update details");
			
			PreparedStatement stmt=conn.prepareStatement("Select cardNo, name,address,phone from tbl_borrower");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("BorrowercardNo:" + rs.getString(1)+ "||BorrowerName : " + rs.getString(2)+"||BorrowerAddress : " + rs.getString(3)+"||BorrowerPhone : " + rs.getString(4));
				}
			
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter borrower card number");
			int borrowercardno=obj.nextInt();			
			System.out.println("Enter borrowerName");			
			String borrowerName=obj.next();
			System.out.println("Enter borrowerAddress");
			String borrowerAddress=obj.next();
			System.out.println("Enter borrowerPhone");
			String borrowerPhone=obj.next();
			stmt = conn.prepareStatement("Update tbl_borrower set name=?,address=?, phone=? where cardNo=?");
			stmt.setString(1, borrowerName);
			stmt.setString(2, borrowerAddress);
			stmt.setString(3, borrowerPhone);  
			stmt.setInt(4, borrowercardno);
			stmt.executeUpdate();
	       System.out.println("Successfully updated details of borrower");     	        
	    
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
