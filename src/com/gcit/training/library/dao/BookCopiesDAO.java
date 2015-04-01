package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gcit.training.library.domain.BookCopies;
public class BookCopiesDAO extends BaseDAO {

	public BookCopiesDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(BookCopies bookCopies) throws SQLException {
		save("Insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)",
				new Object[]{bookCopies.getBook().getBookId(),bookCopies.getBranches().getBranchId(), bookCopies.getNoOfCopies()});		
	}
	public void update(BookCopies bookCopies) throws SQLException {
			save("update tbl_book_copies set noOfCopies = ? where bookId = ?&branchId=?",
					new Object[] { bookCopies.getNoOfCopies(),bookCopies.getBook().getBookId(),bookCopies.getBranches().getBranchId()});
		}
		public void delete(BookCopies bookCopies) throws SQLException {
			save("delete from tbl_book_copies where bookId = ?&branchId=?",
					new Object[] { bookCopies.getBook().getBookId(),bookCopies.getBranches().getBranchId()});
		}
		public List<BookCopies> getAll() throws SQLException {
			return  (List<BookCopies>) read("select * from tbl_book_copies");
		}
		public BookCopies getOne(int bookId,int branchId) throws SQLException {
			List<BookCopies> list = (List<BookCopies>) read("select * from tbl_book_copies where bookId=?&branchId=?",
					new Object[] { bookId,branchId });			
			if(list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		}
		@Override
		public List<BookCopies> mapResult(ResultSet rs) throws SQLException {
			List<BookCopies> list = new ArrayList<BookCopies>();
			BookDAO bdao=new BookDAO(conn);
			LibraryBranchDAO lbDao=new LibraryBranchDAO(conn);		
			while (rs.next()) {
				BookCopies bc= new BookCopies();				
				bc.setBook(bdao.getOne(rs.getInt("bookId")));
				bc.setBranches(lbDao.getOne(rs.getInt("branchId")));
				bc.setNoOfCopies(rs.getInt("noOfCopies"));
				list.add(bc);						
				}
			return list;
		}

		@Override
		public List mapFirstLevelResult(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	}



 
