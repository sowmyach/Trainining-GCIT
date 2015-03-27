package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Borrower {
	public void Borrowermenu() {
        System.out.println("Enter Your Card Number");
		Scanner obj=new Scanner(System.in);
		String bwrcardnum=obj.next();
				
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");		
			PreparedStatement stmt = conn.prepareStatement("select tbo.cardno from tbl_borrower tbo");
			ResultSet rs = stmt.executeQuery();							
				 	while (rs.next()) {
					  ArrayList<String> bcardlist= new ArrayList<String>();
			            bcardlist.add(rs.getString(1));	
				 	
			             while(bcardlist.contains(bwrcardnum)){
			            	 System.out.println("1) Check out a book ");
			            	 System.out.println("2) Return a Book ");
			            	 System.out.println("3) Quit to Previous");
			            	 int option = obj.nextInt();
			            	 while( option!=1 && option!=2&& option!=3){
			     				System.out.println("Please enter correct input");
			            	 option = obj.nextInt();
			            	 }
			            	 
			            	 if(option==1){
			            		checkoutabook cout = new checkoutabook();
			         			cout.ckout( bwrcardnum);}  	 
			            	
			             if(option==2){
			            		 Returnabook rbook= new Returnabook();
			         			rbook.Rtnbook(bwrcardnum);
			            	 }
				 	}
			            	 
			            	 
			            	 
			            	 
			             }    			    
			  			
			
			  }
			
		catch (SQLException e){
		    System.out.println("SQL statement is not executed!");
		    e.printStackTrace();
		}

}
}
	
