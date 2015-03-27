package com.gcit.training.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.dao.PublisherDAO;
import com.gcit.training.library.domain.Publisher;

public class PublisherDAOTest {
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
					Publisher publisher = new Publisher();					
					publisher.setPublisherName("hero");
					publisher.setPublisherAddress("ohio");
					publisher.setPublisherPhone("16718");
					new PublisherDAO(conn).create(publisher);
					conn.commit();
				} catch (SQLException e) {
					conn.rollback();
					e.printStackTrace();
					fail("Borrower create failed!"); 
				}
			}
			@Test
			public void testUpdate() throws SQLException {
				{
					Publisher publisher = new Publisher();
					publisher.setPublisherId(101);
					publisher.setPublisherName("hero");
					publisher.setPublisherAddress("ohio");
					publisher.setPublisherPhone("16718");
				try {
					new PublisherDAO(conn).update(publisher);
					conn.commit();
				} catch (SQLException e) {
					conn.rollback();
					e.printStackTrace();
					fail("Publisher update failed!");  
				}
			}
			}
			@Test
			public void testDelete() throws SQLException {
				Publisher publisher = new Publisher();
				publisher.setPublisherId(101);
				try {
					new PublisherDAO(conn).delete(publisher);
					conn.commit();
				} catch (SQLException e) {
					conn.rollback();
					e.printStackTrace();
					fail("Publisher  delete failed!"); 
				}
			}
			
			@After
			public void destroy() throws SQLException {
				conn.close();
				conn = null;
			}
		}