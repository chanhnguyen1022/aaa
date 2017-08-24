package search;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class SearchForm extends ActionForm {
	private String Customer_Name;
	private String sex;
	private String birthDayStart;
	private String birthDayEnd;
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDayStart() {
		return birthDayStart;
	}
	public void setBirthDayStart(String birthDayStart) {
		this.birthDayStart = birthDayStart;
	}
	public String getBirthDayEnd() {
		return birthDayEnd;
	}
	public void setBirthDayEnd(String birthDayEnd) {
		this.birthDayEnd = birthDayEnd;
	}
	@Override
	public String toString() {
		return "SearchForm [Customer_Name=" + Customer_Name + ", sex=" + sex + ", birthDayStart=" + birthDayStart
				+ ", birthDayEnd=" + birthDayEnd + "]";
	}

}