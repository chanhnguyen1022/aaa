package search;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Edit.EditForm;
import Login.ConnectDB;

public class CustomerDAO {
	ConnectDB connectDB = new ConnectDB();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private final int LIMIT = 5;
	private boolean check = false;

	public List<CustomerForm> getAllcustomers(int index) {
		List<CustomerForm> customers = new ArrayList<CustomerForm>();
		try {
			String query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY CUSTOMER_ID) as row FROM MSTCUSTOMER ) a WHERE row > ? and row <= ?";
			PreparedStatement ps = connectDB.getConnection().prepareStatement(query);
			int start = index * LIMIT;
			ps.setInt(1, start);
			int end = start + LIMIT;
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				CustomerForm customer = new CustomerForm();
				customer.setCustomer_Id(rs.getInt("CUSTOMER_ID"));
				customer.setCustomer_Name(rs.getString("CUSTOMER_NAME"));
				customer.setSex(rs.getString("SEX"));
				customer.setBirthDay(rs.getString("BIRTHDAY"));
				customer.setAddress(rs.getString("ADDRESS"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	public int countCustomers() throws SQLException {
		int count = 0;
		Statement statement = connectDB.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT Count(CUSTOMER_ID) FROM MSTCUSTOMER");
		while (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	public void deleted(int i) throws SQLException {
		Statement statement = connectDB.getConnection().createStatement();
		statement.executeUpdate("DELETE FROM MSTCUSTOMER WHERE CUSTOMER_ID=" + i);
	}

	public boolean EditCustomer(EditForm ef) {
		String sql = "UPDATE MSTCUSTOMER SET" + " CUSTOMER_NAME=?, SEX=?, BIRTHDAY=?, "
				+ "ADDRESS=?, EMAIL=?, INSERT_YMD=?, INSERT_PSN_CD=?," + " UPDATE_PSN_CD=? WHERE CUSTOMER_ID=?";
		System.out.println(ef.toString());
		PreparedStatement ps;
		try {
			ps = connectDB.getConnection().prepareStatement(sql);
			ps.setString(1, ef.getCustomerName());
			ps.setString(2, ef.getSex());
			ps.setString(3, ef.getAddress());
			ps.setString(4, ef.getBirthDay());
			ps.setString(5, ef.getEmail());
			ps.setDate(6, new java.sql.Date(new Date().getTime()));
			ps.setInt(7, ef.getInsertPSN());
			ps.setInt(8, ef.getUpdatePSN());
			ps.setInt(9, ef.getUserid());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public boolean addCustomer(EditForm ac) throws SQLException {
		String sql = "INSERT INTO MSTCUSTOMER (CUSTOMER_NAME,SEX,BIRTHDAY,ADDRESS,EMAIL,INSERT_YMD,INSERT_PSN_CD,UPDATE_PSN_CD) VALUES (?,?,?,?,?,?,?,?)";
		System.out.println(ac.toString());
		try {
			PreparedStatement ud = connectDB.getConnection().prepareStatement(sql);
			ud.setString(1, ac.getCustomerName());
			ud.setString(2, ac.getSex());
			ud.setString(3, ac.getAddress());
			ud.setString(4, ac.getBirthDay());
			ud.setString(5, ac.getEmail());
			ud.setDate(6, new java.sql.Date(new Date().getTime()));
			ud.setInt(7, ac.getInsertPSN());
			ud.setInt(8, ac.getUpdatePSN());
			int executeUpdate = ud.executeUpdate();
			if (executeUpdate > 0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public EditForm getEditForm(int userid) throws SQLException {
		String get = "SELECT*FROM MSTCUSTOMER WHERE CUSTOMER_ID= '" + userid + "'";
		Statement statement = connectDB.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(get);
		EditForm editForm = new EditForm();
		while (rs.next()) {
			editForm.setUserid(rs.getInt("CUSTOMER_ID"));
			editForm.setCustomerName(rs.getString("CUSTOMER_NAME"));
			editForm.setSex(rs.getString("SEX"));
			editForm.setBirthDay(rs.getString("BIRTHDAY"));
			editForm.setAddress(rs.getString("ADDRESS"));
			editForm.setEmail(rs.getString("EMAIL"));
		}
		return editForm;
	}

	public int getPSNCDbyUsername(String customername) throws SQLException {
		String get = "SELECT*FROM MSTUSER WHERE USERID = '" + customername + "'";
		Statement statement = connectDB.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(get);
		rs.next();
		return rs.getInt("PSN_CD");

	}

	public static void main(String[] args) throws SQLException {
		System.out.println(new java.sql.Date(new Date().getTime()));
	}
}