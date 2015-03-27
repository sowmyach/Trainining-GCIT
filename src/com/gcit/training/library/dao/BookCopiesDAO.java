package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.training.library.domain.BookCopies;

public class BookCopiesDAO extends BaseDAO {

	public BookCopiesDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(BookCopies bookCopies) throws SQLException {
		save("Insert into tbl_book_copies set noOfcopies=?",new Object[]{bookCopies.getNoOfCopies()});
		
	}

	public void update(BookCopies bookCopies) throws SQLException {
			save("update tbl_book_copies set noOfCopies = ? where bookId = ?",
					new Object[] { bookCopies.getNoOfCopies(),bookCopies.getBook().getBookId()});
		}

		public void delete(BookCopies bookCopies) throws SQLException {
			save("delete from tbl_book_copies where bookId = ? ",
					new Object[] { bookCopies.getBook().getBookId()});
		}

		@Override
		public List<?> mapResult(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	}



 
