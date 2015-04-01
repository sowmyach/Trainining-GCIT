package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import org.junit.After;
import org.junit.Test;




import com.gcit.training.library.dao.BookLoanDAO;
import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.BookLoan;
import com.gcit.training.library.domain.Borrower;
import com.gcit.training.library.domain.LibraryBranch;



public class BookLoanDAOTest {
	private Connection conn;


	@Test
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
		BookLoan bookLoan=new BookLoan();
		
		Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		bookLoan.setDateDue(ourJavaTimestampObject);
		bookLoan.setDateOut(ourJavaTimestampObject);
		
		Book book=new Book();
		book.setBookId(5);
		bookLoan.setBook(book);
		
		LibraryBranch libraryBranch=new LibraryBranch();
		libraryBranch.setBranchId(2);
		bookLoan.setBranch(libraryBranch);	
		
		Borrower borrower=new Borrower();
		borrower.setCardNo(4);
		bookLoan.setBorrower(borrower);
		
	
	try{
		new BookLoanDAO(conn).create(bookLoan);
		conn.commit();
		
	}
	catch(Exception e) {
		e.printStackTrace();
		fail("No connection!");
	}
	}
	

	@Test
	public void testUpdate() throws SQLException {
BookLoan bookLoan=new BookLoan();
		
		Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		bookLoan.setDateDue(ourJavaTimestampObject);
		bookLoan.setDateOut(ourJavaTimestampObject);
		
		Book book=new Book();
		book.setBookId(2);
		bookLoan.setBook(book);
		
		LibraryBranch libraryBranch=new LibraryBranch();
		libraryBranch.setBranchId(6);
		bookLoan.setBranch(libraryBranch);
		
		Borrower borrower=new Borrower();
		borrower.setCardNo(3);
		bookLoan.setBorrower(borrower);
		try {
			new BookLoanDAO(conn).update(bookLoan);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book Loan update failed!");   
		}
	}

	@Test
	public void testDelete() throws SQLException {
		BookLoan bookLoan=new BookLoan();
		
		Book book=new Book();
		book.setBookId(2);
		bookLoan.setBook(book);
		
		LibraryBranch libraryBranch=new LibraryBranch();
		libraryBranch.setBranchId(6);
		bookLoan.setBranch(libraryBranch);
		
		Borrower borrower=new Borrower();
		borrower.setCardNo(3);
		bookLoan.setBorrower(borrower);
		
		try {
			new BookLoanDAO(conn).delete(bookLoan);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Book Loan delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}
