package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.dao.BookCopiesDAO;
import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.BookCopies;
import com.gcit.training.library.domain.LibraryBranch;

public class BookCopiesDAOTest {

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
		
			BookCopies bookCopies=new BookCopies();
			bookCopies.setNoOfCopies(1);			
			
			Book book=new Book();
			book.setBookId(4);
			bookCopies.setBook(book);
						
			LibraryBranch libraryBranch=new LibraryBranch();
			libraryBranch.setBranchId(4);
			bookCopies.setBranches(libraryBranch);			
					
			try {	
			new BookCopiesDAO(conn).create(bookCopies);			
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("BookCopies create failed!"); 
		}		
	}
	@Test
	public void testUpdate() throws SQLException {
		BookCopies bookCopies=new BookCopies();
		bookCopies.setNoOfCopies(1);
		
		Book book= new Book();
		book.setBookId(2);
		bookCopies.setBook(book);
		
		LibraryBranch libraryBranch=new LibraryBranch();
		libraryBranch.setBranchId(2);
		bookCopies.setBranches(libraryBranch);	
		
		try {
			new BookCopiesDAO(conn).update(bookCopies);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book  Copies update failed!");   
		}
	}
	@Test
	public void testDelete() throws SQLException {
		BookCopies bookCopies=new BookCopies();
		
		Book b = new Book();
		b.setBookId(2);
		bookCopies.setBook(b);	
		
		LibraryBranch libraryBranch=new LibraryBranch();
		libraryBranch.setBranchId(2);
		bookCopies.setBranches(libraryBranch);	
		
		try {
			new BookCopiesDAO(conn).delete(bookCopies);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book Copies delete failed!"); 
		}
	}	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}