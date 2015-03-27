package com.gcit.training.library.domain;

import java.util.List;

public class Book extends AbstractDomian{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5008011787354390526L;

	/**
	 * 
	 */
	
	private int bookId;
	private String title;
	private List<Author>authors;
	private Publisher publisher;
	private List<Genre> genres;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	

}
