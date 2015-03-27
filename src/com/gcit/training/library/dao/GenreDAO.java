package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;

import com.gcit.training.library.domain.Genre;

public class GenreDAO extends BaseDAO {

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
	public List<?> mapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}


