package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.gcit.training.library.domain.Publisher;

public class PublisherDAO extends BaseDAO {
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
}

	
