/**
 * @(#)Login form check username ? password? .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package Login;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO {
	public boolean authenticate(String UserId, String Password) {
		ConnectDB connectDB = new ConnectDB();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = connectDB.getConnection();
			String sql = " SELECT *FROM MSTUSER WHERE USERID=? AND PASSWORD=?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, UserId);
			ps.setString(2, Password);

			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		UserLoginDAO us = new UserLoginDAO();
		System.out.println(us);
	}
}