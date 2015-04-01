package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.Publisher;

public class PublisherDAO extends BaseDAO<Publisher>{
	public PublisherDAO(Connection connection) {
		this.conn = connection; {
}
	}

	public void create(Publisher publisher) throws SQLException {
		save("insert into tbl_publisher (publisherName,publisherAddress,publisherPhone) values (?,?,?)",
				new Object[] {publisher.getPublisherName(),publisher.getPublisherAddress(),publisher.getPublisherPhone() });
	}

	public void update(Publisher publisher) throws SQLException {
		save("update tbl_publisher set publisherName=?,publisherAddress=?,publisherPhone=? where publisherId= ?",
				new Object[] {publisher.getPublisherName(),publisher.getPublisherAddress(),publisher.getPublisherPhone(),publisher.getPublisherId()});
	}

	public void delete(Publisher publisher) throws SQLException {
		save("delete from tbl_publisher where publisherId= ?",
				new Object[] { publisher.getPublisherId() });
	}
	public List<Publisher> getAll() throws SQLException {
		return (List<Publisher>) read("select * from tbl_publisher");
	}

	public Publisher getOne(int publisherId) throws SQLException {
		List<Publisher> list = (List<Publisher>) read("select * from tbl_publisher where publisherId = ?",
				                                         new Object[] { publisherId });
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Publisher> mapResult(ResultSet rs) throws SQLException {
		List<Publisher> list = new ArrayList<Publisher>();
		while (rs.next()) {
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherPhone"));

			list.add(a);
		}
		return list;
	}

	@Override
	public List<Publisher> mapFirstLevelResult(ResultSet rs) throws SQLException {
		List<Publisher> list = new ArrayList<Publisher>();
		BookDAO bDAO = new BookDAO(conn);
		while (rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(rs.getInt("publisherId"));
			publisher.setPublisherName(rs.getString("publisherName"));
			publisher.setPublisherAddress(rs.getString("publisherAddress"));
			publisher.setPublisherPhone(rs.getString("publisherPhone"));
			List<Book> bookList = (List<Book>) bDAO.read("select *  from tbl_book where bookId in (select publisherId from tbl_publisher where publisherId = ?)",
					new Object[] {publisher.getPublisherId()});
					publisher.setBooks(bookList);
					

					list.add(publisher);
				}

			
		return list;
		
	}
}

	
