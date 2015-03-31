package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Borrower;
import com.gcit.training.library.domain.Publisher;
public class BorrowerDAO extends BaseDAO<Borrower> {
	public BorrowerDAO(Connection connection) {
		this.conn = connection; {
}
	}

	public void create(Borrower borrower) throws SQLException {
		save("insert into tbl_borrower (name,address,phone) values (?,?,?)",
				new Object[] { borrower.getBorrowerName(),borrower.getBorrowerAddress(),borrower.getBorrowerPhone() });
	}

	public void update(Borrower borrower) throws SQLException {
		save("update tbl_borrower set name = ?,address=?,phone=? where cardNo = ?",
				new Object[] {borrower.getBorrowerName(),borrower.getBorrowerAddress(),borrower.getBorrowerPhone(),borrower.getCardNo()});
	}

	public void delete(Borrower borrower) throws SQLException {
		save("delete from tbl_borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
	}

	@Override
	public List<Borrower> mapResult(ResultSet rs) throws SQLException {
		List<Borrower> list = new ArrayList<Borrower>();
		while (rs.next()) {
			Borrower bo = new Borrower();
			bo.setCardNo(rs.getInt("cardNo"));
			bo.setBorrowerName(rs.getString("borrowerName"));
			bo.setBorrowerAddress(rs.getString("borrowerAddress"));
			bo.setBorrowerPhone(rs.getString("borrowerPhone"));

			list.add(bo);
		}
		return list;
	}
}
