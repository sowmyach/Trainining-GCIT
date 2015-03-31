package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.dao.AuthorDAO;
import com.gcit.training.library.dao.BookCopiesDAO;
import com.gcit.training.library.dao.PublisherDAO;
import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.BookCopies;

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
		
	}

	@Test
	public void testUpdate() throws SQLException {
		BookCopies bookCopies=new BookCopies();
		
		bookCopies.setNoOfCopies(1);
		
		Book b = new Book();
		b.setBookId(2);
		bookCopies.setBook(b);
		
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
		
		try {
			new BookCopiesDAO(conn).delete(bookCopies);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book Copies delete failed!"); 
		}
	}
	public List<BookCopies> mapResult(ResultSet rs) throws SQLException {
		List<BookCopies> list = new ArrayList<BookCopies>();
	BookCopiesDAO bcDAO = new BookCopiesDAO(conn);	
	while (rs.next()) {
		BookCopies bc = new BookCopies();
		bc.setNoOfCopies(7);
		List<Author> authorList = (List<Author>) aDAO.read("select * from tbl_book where bookId in (select authorId from tbl_book_authors where bookId = ?",
				new Object[] { b.getBookId() });
		b.setAuthors(authorList);
		
	
		
		b.setPublisher(pDAO.getOne(rs.getInt("publisherId")));

		list.add(b);
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}