package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectDB;

public class SearchDAO {
	ConnectDB connectDB = new ConnectDB();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CustomerForm> searchCustomers(SearchForm searchForm) {
		List<CustomerForm> customers = new ArrayList<CustomerForm>();
		System.out.println(searchForm.getBirthDayEnd().length());
		StringBuffer query = new StringBuffer();
		query.append("SELECT * FROM MSTCUSTOMER WHERE SEX = '"+searchForm.getSex()+"'");
		if(searchForm.getCustomer_Name() != null ||
				!searchForm.getCustomer_Name().isEmpty()|| !searchForm.equals("")){
			query.append(" AND CUSTOMER_NAME LIKE '%"+searchForm.getCustomer_Name()+"%'");
		}
		if(searchForm.getBirthDayStart().length() != 0){
			query.append(" AND CONVERT(date, BIRTHDAY) BETWEEN '"+searchForm.getBirthDayStart()+"'");
		}
		if(searchForm.getBirthDayEnd().length() != 0){
			query.append(" AND '"+searchForm.getBirthDayEnd()+"'");
		}
		System.out.println(query.toString());
		try {
			Statement statement = connectDB.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query.toString());
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

}
