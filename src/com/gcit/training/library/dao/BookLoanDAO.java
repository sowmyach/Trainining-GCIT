package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.training.library.domain.BookLoan;

public class BookLoanDAO extends BaseDAO {

	public BookLoanDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(BookLoan bookLoan) throws SQLException {
		
		}
	

	public void update(BookLoan bookLoan) throws SQLException {
			save("update tbl_book_loan set dateOut=?,dueDate=? where cardNo = ?",
					new Object[] { bookLoan.getDateOut(),bookLoan.getDateDue(),bookLoan.getBorrower().getCardNo()});
		}

		public void delete(BookLoan bookLoan) throws SQLException {
			save("delete from tbl_book_loan where cardNo = ? ",
					new Object[] { bookLoan.getBorrower().getCardNo()});
		}

		@Override
		public List<?> mapResult(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	

}
