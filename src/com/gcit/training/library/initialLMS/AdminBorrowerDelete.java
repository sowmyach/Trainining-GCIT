package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminBorrowerDelete {

	public void adminBorrowerDelete() {
		try{		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			System.out.println("Select Borrower card number from the following list to delete details");			
			PreparedStatement stmt=conn.prepareStatement("Select cardNo, name,address,phone from tbl_borrower");			
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				System.out.println("BorrowercardNo:" + rs.getString(1)+ " ||BorrowerrName : " + rs.getString(2)+" ||BorrowerAddress : " + rs.getString(3)+"|| BorrowerPhone : " + rs.getString(4));
				}
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter borrower card number to delete");
			int borrowercardno=obj.nextInt();							
			
			stmt = conn.prepareStatement("DELETE from tbl_borrower where cardNo=?");	
			  
			stmt.setInt(1, borrowercardno);
			stmt.executeUpdate();
		       System.out.println("Successfully deleted borrower details"); 
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
