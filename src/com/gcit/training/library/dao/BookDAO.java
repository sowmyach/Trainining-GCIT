package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Book;


public class BookDAO extends BaseDAO {

	public BookDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(Book book) throws SQLException {
		int bookId = -1;
		if (book.getPublisher() == null) {
			bookId = saveReturnGen(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(), null });
		} else {
			bookId = saveReturnGen(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(),
							book.getPublisher().getPublisherId() });
		}

		if (book.getAuthors() != null && book.getAuthors().size() > 0) {
			for (Author a : book.getAuthors()) {
				save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
						new Object[] { bookId, a.getAuthorId() });
			}
		}
	}

	public void update(Book book) throws SQLException {
			save("update tbl_book set title = ? where bookId = ?",
					new Object[] { book.getTitle(),book.getBookId()});
		}

		public void delete(Book book) throws SQLException {
			save("delete from tbl_book where bookId = ? ",
					new Object[] { book.getBookId()});
		}
	
@Override
public List<Book> mapResult(ResultSet rs) throws SQLException {
		List<Book> list = new ArrayList<Book>();

	AuthorDAO aDAO = new AuthorDAO(conn);
	PublisherDAO pDAO = new PublisherDAO(conn);
	while (rs.next()) {
		Book b = new Book();
		b.setBookId(rs.getInt("bookId"));
		b.setTitle(rs.getString("title"));

		List<Author> authorList = (List<Author>) aDAO.read("select * from tbl_book where bookId in (select authorId from tbl_book_authors where bookId = ?",
				new Object[] { b.getBookId() });
		b.setAuthors(authorList);
		
	
		
		b.setPublisher(pDAO.getOne(rs.getInt("publisherId")));

		list.add(b);
	}
	return list;
}
}



