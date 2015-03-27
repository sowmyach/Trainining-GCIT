package com.gcit.training.library.domain;

public class BookCopies extends AbstractDomian{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2510727794966883636L;
	/**
	 * 
	 */	
	private Book book;
	private int noOfCopies;
	private LibraryBranch branches;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public LibraryBranch getBranches() {
		return branches;
	}
	public void setBranches(LibraryBranch branches) {
		this.branches = branches;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result
				+ ((branches == null) ? 0 : branches.hashCode());
		result = prime * result + noOfCopies;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branches == null) {
			if (other.branches != null)
				return false;
		} else if (!branches.equals(other.branches))
			return false;
		if (noOfCopies != other.noOfCopies)
			return false;
		return true;
	}

}
