package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.Borrower;
import com.gcit.training.library.domain.Genre;

public class GenreDAO extends BaseDAO<Genre> {

	public GenreDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(Genre genre) throws SQLException {
		save("insert into tbl_genre (genre_name) values (?)",
				new Object[] { genre.getGenreName() });
	}

	public void update(Genre genre) throws SQLException {
		save("update tbl_genre set genre_name = ? where genre_id = ?",
				new Object[] { genre.getGenreName(), genre.getGenreId() });
	}

	public void delete(Genre genre) throws SQLException {
		save("delete from tbl_genre where genre_id = ?",
				new Object[] { genre.getGenreId() });
	}

	@Override
	public List<Genre> mapResult(ResultSet rs) throws SQLException {
		List<Genre> list = new ArrayList<Genre>();
		BookDAO bDAO = new BookDAO(conn);
		while (rs.next()) {
			Genre g = new Genre();
			//Book b = new Book();
			//b.setBookId(1);
			//g.setBook(b);
			g.setGenreId(rs.getInt("cardNo"));
			g.setGenreName(rs.getString("borrowerName"));
			List<Book> bookList = (List<Book>) bDAO.read("select *  from tbl_book_genre where bookId in (select title from tbl_book where bookId = ?",
			new Object[] {((Book) g.getBooks()).getBookId() });
			g.setBooks(bookList);
			

			list.add(g);
		}
		return list;
	}
}


