/**
 *@author chanh-nm,
 * @(#)Connect database .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 * Version 1.1.
 */
package Edit;

import java.sql.Date;

import org.apache.struts.action.ActionForm;
/**
 * Form contain value input to user. Store data for processing, handle
 * validation errors and send data to Action for processing
 */
@SuppressWarnings("serial")
public class EditForm extends ActionForm {
	private int userid;
	private String customerName;
	private String sex;
	private String birthDay;
	private String address;
	private String email;
	private Date insert;
	private int insertPSN;
	private int updatePSN;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getInsert() {
		return insert;
	}
	public void setInsert(Date insert) {
		this.insert = insert;
	}
	public int getInsertPSN() {
		return insertPSN;
	}
	public void setInsertPSN(int insertPSN) {
		this.insertPSN = insertPSN;
	}
	public int getUpdatePSN() {
		return updatePSN;
	}
	public void setUpdatePSN(int updatePSN) {
		this.updatePSN = updatePSN;
	}
	@Override
	public String toString() {
		return "EditForm [userid=" + userid + ", customerName=" + customerName + ", sex=" + sex + ", birthDay="
				+ birthDay + ", address=" + address + ", email=" + email + ", insert=" + insert + ", insertPSN="
				+ insertPSN + ", updatePSN=" + updatePSN + "]";
	}
}
