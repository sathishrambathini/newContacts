package com.agilecrm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agilecrm.dao.daoOperations;
import com.agilecrm.model.Contact;
import com.agilecrm.util.JdbcCon;

public class DaoImpl implements daoOperations {

	public void addContact(Contact c) {
		Connection conn = JdbcCon.getConnect();
		try {
			String query = "insert into contacts (firstname,lastname,email,createdby,createddate,address,dob,isactive,updatedby,updateddate) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getFirstName());
			pstmt.setString(2, c.getLastName());
			pstmt.setString(3, c.getEmail());
			pstmt.setString(4, c.getCreatedBy());
			pstmt.setString(5, c.getCreatedDate());
			pstmt.setString(6, c.getAddress());
			pstmt.setString(7, c.getDob());
			pstmt.setBoolean(8, c.isActive());
			pstmt.setString(9, c.getUpdatedBy());
			pstmt.setString(10, c.getUpdatedDate());
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("Record INSERTED ");
			} else {
				System.out.println("Insertion failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delContact(String email) {
		Connection conn = JdbcCon.getConnect();
		String query = "delete from contacts where email = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("Record deleted ");
			} else {
				System.out.println("not deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateContact(Contact c, String email) {
		Connection conn = JdbcCon.getConnect();
		try {
			String query = "update contacts set firstname= ? where email=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getFirstName());
			pstmt.setString(2, email);
			/**
			 * pstmt.setString(2, c.getLastName()); pstmt.setString(3, c.getEmail());
			 * pstmt.setString(4, c.getCreatedBy()); pstmt.setString(5, c.getCreatedDate());
			 * pstmt.setString(6, c.getAddress()); pstmt.setString(7, c.getDob());
			 * pstmt.setBoolean(8, c.isActive()); pstmt.setString(9, c.getUpdatedBy());
			 * pstmt.setString(10, c.getUpdatedDate());
			 */
			int n = pstmt.executeUpdate();
			if (n == 1) {
				System.out.println("Record UPDATED with email  " + email);

			} else {
				System.out.println("Updation failed ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Contact retrieveContact(int id) {
		Connection conn = JdbcCon.getConnect();
		Contact c = new Contact();
		ResultSet rs = null;
		try {
			String query = "select * from contacts where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setCreatedBy(rs.getString(5));
				c.setCreatedDate(rs.getString(6));
				c.setAddress(rs.getString(7));
				c.setDob(rs.getString(8));
				c.setActive(rs.getBoolean(9));
				c.setUpdatedBy(rs.getString(10));
				c.setUpdatedDate(rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

}
