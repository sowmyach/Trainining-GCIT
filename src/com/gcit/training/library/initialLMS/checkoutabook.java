package com.gcit.training.library.initialLMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;


public class checkoutabook {

	public void ckout(String bwrcardnum) {
		
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");	
			Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			PreparedStatement stmt = conn.prepareStatement("Select branchid,branchname,branchaddress from tbl_library_branch ");	
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("Branchid: " + rs.getString(1)+"||Branchname: " + rs.getString(2)+" ||Branchaddress:" + rs.getString(3));	
			}
		System.out.println(" Enter the BranchId to pickup ");
		Scanner obj=new Scanner(System.in);
		String branchid=obj.next();
		stmt = conn.prepareStatement("select tbc.bookid,tb.title from tbl_library_branch tlb join tbl_book_copies tbc on tlb.branchid=tbc.branchid join tbl_book tb on tbc.bookid=tb.bookid where tlb.branchid=? having count(tbc.noofcopies>0);");
		stmt.setString(1,branchid);
		
		rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("Bookid: " + rs.getString(1)+" ||Book Title: " + rs.getString(2));
		}
		System.out.println(" Enter the BookId to checkout ");
		String bookid=obj.next();
		
		
		
		//String dateout=obj.next();
		//String duedate=obj.next();
			stmt = conn.prepareStatement("INSERT INTO tbl_book_loans (bookid,branchid,cardno,dateout,duedate) VALUES(?,?,?,?,?)");		
			stmt.setString(1, bookid);
			stmt.setString(2, branchid);
			stmt.setString(3, bwrcardnum);
			stmt.setTimestamp(4, ourJavaTimestampObject);
			stmt.setTimestamp(5, ourJavaTimestampObject);
			stmt.executeUpdate();
			System.out.println("Insert Successfull");
			branchmenu br = new branchmenu();
			br.brmenu();						
		}	

	catch(SQLException e){
		    System.out.println("SQL statement is not executed!");
		    e.printStackTrace();
		}
		}
		

	}

	
