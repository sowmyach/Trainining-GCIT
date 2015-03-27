package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class UpdateBranchId {

	public void update_bid(String brhid) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			PreparedStatement stmt = conn.prepareStatement("Select branchname,branchaddress from tbl_library_branch where branchid=?");
			stmt.setString(1, brhid);
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				System.out.println("Existing Branchname:" + rs.getString(1)+ "||Existing Branchaddress : " + rs.getString(2));
				}
			System.out.println("Enter the new branchname");
			Scanner obj=new Scanner(System.in);
			String bname=obj.next();
			System.out.println("Enter the new branchaddress");
			String badd=obj.next();
			String ntn="N/A";	
					if(bname==ntn && badd==ntn){
						System.out.println("No change");
					}
					else{
						stmt = conn.prepareStatement("Update tbl_library_branch set branchname=?,branchaddress=?  where branchid=?");
						stmt.setString(1, bname);
						stmt.setString(2, badd);
						stmt.setString(3, brhid);
						stmt.executeUpdate();
						System.out.println("Update Successfull");
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


