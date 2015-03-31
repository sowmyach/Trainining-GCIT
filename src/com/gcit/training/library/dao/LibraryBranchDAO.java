package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Book;
import com.gcit.training.library.domain.Genre;
import com.gcit.training.library.domain.LibraryBranch;
import com.gcit.training.library.domain.Publisher;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch> {

	public LibraryBranchDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(LibraryBranch libraryBranch) throws SQLException {
		save("insert into tbl_library_branch (branchName,branchAddress) values (?,?)",
				new Object[] { libraryBranch.getBranchName(),libraryBranch.getBranchAddress() });
	}

	public void update(LibraryBranch libraryBranch) throws SQLException {
		save("update tbl_library_branch set branchname = ?,branchAddress=? where branchId = ?",
				new Object[] { libraryBranch.getBranchName(),libraryBranch.getBranchAddress(),libraryBranch.getBranchId()});
	}

	public void delete(LibraryBranch libraryBranch) throws SQLException {
		save("delete from tbl_library_branch where branchId = ? ",
				new Object[] { libraryBranch.getBranchId()});
	}
	public List<LibraryBranch> getAll() throws SQLException {
		return (List<LibraryBranch>) read("select * from tbl_library_branch");
	}

	public LibraryBranch getOne(int branchId) throws SQLException {
		List<LibraryBranch> list = (List<LibraryBranch>) read("select * from tbl_library_branch where branchId = ?",
				                                         new Object[] { branchId });
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<LibraryBranch> mapResult(ResultSet rs) throws SQLException {
		List<LibraryBranch> list = new ArrayList<LibraryBranch>();
		while (rs.next()) {
			LibraryBranch lb = new LibraryBranch();
			lb.setBranchId(rs.getInt("branchId"));
			lb.setBranchName(rs.getString("branchName"));
			lb.setBranchAddress(rs.getString("branchAddress"));
			

			list.add(lb);
		}
		return list;
	
	}
	}

