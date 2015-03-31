package com.gcit.training.library.initialLMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class AdministratorLibraryBranches {

	public void adminLibraryBranches() {
		try{
			System.out.println("enter library branch name");
			Scanner scan = new Scanner(System.in);
			String name = scan.next();
			System.out.println("enter branch address");
			String add = scan.next();
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/library", "root", "root");
	PreparedStatement stmt = conn.prepareStatement("insert into tbl_library_branch (branchname,branchaddress) values (?,?)");
	stmt.setString(1,name);
	stmt.setString(2, add);
	stmt.executeUpdate();
	System.out.println("succesfully inserted");
}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	
	}
		
	}


