package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gcit.training.library.dao.LibraryBranchDAO;

import com.gcit.training.library.domain.LibraryBranch;

public class LibraryBranchDAOTest {

private Connection conn;
	
	@Before
	public void init() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/library", "root", "");
			conn.setAutoCommit(false);
		} catch(Exception e) {
			e.printStackTrace();
			fail("No connection!");
		}
	}
	@Test
	public void testCreate() throws SQLException {
		try {
			LibraryBranch libraryBranch = new LibraryBranch();
			libraryBranch.setBranchId(1);
			libraryBranch.setBranchName("hero");
			libraryBranch.setBranchAddress("ohio");
			
			new LibraryBranchDAO(conn).create(libraryBranch);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("LibraryBranch create failed!"); 
		}
	}
	@Test
	public void testUpdate() throws SQLException {
		LibraryBranch libraryBranch = new LibraryBranch();
		libraryBranch.setBranchId(1);
		libraryBranch.setBranchName("hero");
		libraryBranch.setBranchAddress("ohio");
		try {
			new LibraryBranchDAO(conn).update(libraryBranch);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("libraryBranch update failed!");  
		}
	}
	@Test
	public void testDelete() throws SQLException {
		LibraryBranch libraryBranch = new LibraryBranch();
		libraryBranch.setBranchId(1);
		try {
			new LibraryBranchDAO(conn).delete(libraryBranch);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Borrower  delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}

