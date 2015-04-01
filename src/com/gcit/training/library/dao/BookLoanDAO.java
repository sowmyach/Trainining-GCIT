package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.BookCopies;
import com.gcit.training.library.domain.BookLoan;
import com.gcit.training.library.domain.Borrower;

public class BookLoanDAO extends BaseDAO {

	public BookLoanDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(BookLoan bookLoan) throws SQLException {
			save("insert into tbl_book_loan (bookId,branchId,cardNo,duedate,dateOut) values (?,?,?,?,?)",
					new Object[] { bookLoan.getBook().getBookId(),bookLoan.getBranch().getBranchId(),bookLoan.getBorrower().getCardNo(),
					bookLoan.getDateOut(),bookLoan.getDateDue()});
		
		}
	

	public void update(BookLoan bookLoan) throws SQLException {
			save("update tbl_book_loan set dateOut=?,dueDate=? where cardNo = ?&branchId=?&bookId=?",
					new Object[] { bookLoan.getBook().getBookId(),bookLoan.getBranch().getBranchId(),bookLoan.getBorrower().getCardNo(),
					bookLoan.getDateOut(),bookLoan.getDateDue()});
		}

		public void delete(BookLoan bookLoan) throws SQLException {
			save("delete from tbl_book_loan where cardNo = ?&branchId=?&bookId=? ",
					new Object[] { bookLoan.getBorrower().getCardNo(),bookLoan.getBook().getBookId(),bookLoan.getBranch().getBranchId()});
		}
		public List<BookLoan> getAll() throws SQLException {
			return  (List<BookLoan>) read("select * from tbl_book_loans");
		}

		public BookLoan getOne(int bookId,int branchId,int cardNo) throws SQLException {
			List<BookLoan> list = (List<BookLoan>) read(
					"select * from tbl_book_loan where bookId = ?,branchId=?,cardNo=?",
					new Object[] { bookId,branchId,cardNo });
			
			if(list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		}
		@Override
		public List<BookLoan> mapResult(ResultSet rs) throws SQLException {
			List<BookLoan> list = new ArrayList<BookLoan>();
			BookDAO bdao=new BookDAO(conn);
			LibraryBranchDAO lbDao=new LibraryBranchDAO(conn);
			BorrowerDAO bodao=new BorrowerDAO (conn);
		
			while (rs.next()) {
				BookLoan bl= new BookLoan();
				
				bl.setBook(bdao.getOne(rs.getInt("bookId")));
				bl.setBranch(lbDao.getOne(rs.getInt("branchId")));
				bl.setBorrower(bodao.getOne(rs.getInt("cardNo")));
				

				list.add(bl);
			
			
			 
					
				}
			return list;
		}

		@Override
		public List mapFirstLevelResult(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	

}
