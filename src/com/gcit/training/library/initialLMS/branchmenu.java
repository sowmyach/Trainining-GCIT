package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class branchmenu {
public void brmenu() {
	try{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
		System.out.println("Select a BranchId from the list of Library Branches ");
		PreparedStatement stmt = conn.prepareStatement("Select branchId,branchname from tbl_library_branch");
		ResultSet rs = stmt.executeQuery();
		

		while (rs.next()) {
			System.out.println("Branchid:" + rs.getString(1)+ " Branchname : " + rs.getString(2));
			}
		Scanner obj=new Scanner(System.in); 		
		 String brhid=obj.next(); 
	      System.out.println("1) Update the details of the Library");
	      System.out.println("2) Add copies of Book to the Branch ");
	      System.out.println("3) Quit to previous ");
	      int ch = obj.nextInt();
	      while( ch!=1 && ch!=2&& ch!=3){
				System.out.println("Please enter correct input");
				ch = obj.nextInt();
	      }	
	   
	      if (ch==1){
	    	  UpdateBranchId uid=new UpdateBranchId();
	    	  uid.update_bid(brhid);	    	  
	      }
	      if(ch==2){
	    	  BranchAddBooks ab=new BranchAddBooks();
	    	  ab.add_books(brhid);
	      }
	      if(ch==3){
	    	  branchmenu br = new branchmenu();
	    	  br.brmenu();
	      }
	      
	      }
catch (SQLException e){
    System.out.println("SQL statement is not executed!");
    e.printStackTrace();
}

}
 							}

					
				