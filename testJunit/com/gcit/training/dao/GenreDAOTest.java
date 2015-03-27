package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.dao.GenreDAO;

import com.gcit.training.library.domain.Genre;


public class GenreDAOTest {

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
			Genre genre = new Genre();					
		genre.setGenreName("children");
			
			new GenreDAO(conn).create(genre);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("genre create failed!"); 
		}
	}
	@Test
	public void testUpdate() throws SQLException {
		{
			Genre genre = new Genre();	
			genre.setGenreId(1);
			genre.setGenreName("kids");
			
		try {
			new GenreDAO(conn).update(genre);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("genre update failed!");  
		}
	}
	}
	@Test
	public void testDelete() throws SQLException {
		Genre genre = new Genre();
		genre.setGenreId(1);
		try {
			new GenreDAO(conn).delete(genre);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("genre  delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}