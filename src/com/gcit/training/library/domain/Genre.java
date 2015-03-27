package com.gcit.training.library.domain;

import java.util.List;

public class Genre extends AbstractDomian{

	/**
	 * 
	 */
	private static final long serialVersionUID = -224135311248323119L;
	
	private int genreId;
	private String genreName;
	private List<Book> books;
	public int getGenreId() {
		return genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
