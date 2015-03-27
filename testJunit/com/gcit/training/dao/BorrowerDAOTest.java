package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.gcit.training.library.dao.BorrowerDAO;
import com.gcit.training.library.domain.Borrower;

public class BorrowerDAOTest {

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
			Borrower borrower = new Borrower();
			borrower.setCardNo(1);
			borrower.setBorrowerName("hero");
			borrower.setBorrowerAddress("ohio");
			borrower.setBorrowerPhone("16718");
			new BorrowerDAO(conn).create(borrower);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Borrower create failed!"); 
		}
	}
	@Test
	public void testUpdate() throws SQLException {
		Borrower borrower = new Borrower();
		borrower.setCardNo(1);
		borrower.setBorrowerName("h");
		borrower.setBorrowerAddress("ohio");
		borrower.setBorrowerPhone("168");
		try {
			new BorrowerDAO(conn).update(borrower);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Borrower update failed!");  
		}
	}
	@Test
	public void testDelete() throws SQLException {
		Borrower borrower = new Borrower();
		borrower.setCardNo(2);
		try {
			new BorrowerDAO(conn).delete(borrower);
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

