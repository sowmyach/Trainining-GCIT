package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.SQLException;


import com.gcit.training.library.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO {

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
}
