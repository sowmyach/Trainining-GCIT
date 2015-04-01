package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.dao.AuthorDAO;
import com.gcit.training.library.dao.BookCopiesDAO;
import com.gcit.training.library.dao.BookDAO;
import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Book;

public class BookDAOTest {
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
		Book book=new Book();
		book.setTitle("2states");
		new BookDAO(conn).create(book);
		
		Author author=new Author();
		author.setAuthorName("helen");
		new AuthorDAO(conn).create(author);
		try {
			new BookDAO(conn).create(book);	
			
			
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book create failed!"); 
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		Book book=new Book();
		
		book.setTitle("2states");
		try {
			new BookDAO(conn).update(book);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book update failed!");  
		}
	}

	@Test
	public void testDelete() throws SQLException {
		Book book=new Book();
		book.setBookId(1);
		try {
			new BookDAO(conn).delete(book);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}