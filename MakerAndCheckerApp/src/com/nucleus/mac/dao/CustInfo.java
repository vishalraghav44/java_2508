package com.nucleus.mac.dao;

public class CustInfo {

	public CustInfo(String customer_code, String customer_pincode,
			String contact_no, String customer_name, String customer_address1,
			String customer_address2, String email_address,
			String primary_contact_person, String record_status,
			String active_inactive_flag, String create_date, String created_by,
			String modified_date, String modified_by, String authorized_date,
			String authorized_by) {

		super();

		this.customer_code = customer_code;
		this.customer_pincode = customer_pincode;
		this.contact_no = contact_no;
		this.customer_name = customer_name;
		this.customer_address1 = customer_address1;
		this.customer_address2 = customer_address2;
		this.email_address = email_address;
		this.primary_contact_person = primary_contact_person;
		this.record_status = record_status;
		this.active_inactive_flag = active_inactive_flag;
		this.create_date = create_date;
		this.created_by = created_by;
		this.modified_date = modified_date;
		this.modified_by = modified_by;
		this.authorized_date = authorized_date;
		this.authorized_by = authorized_by;
	}

	/* private int customer_id; */

	public CustInfo CustInfoConstruct() {

		CustInfo obj = new CustInfo(customer_code, customer_pincode,
				contact_no, customer_name, customer_address1,
				customer_address2, email_address, primary_contact_person,
				record_status, active_inactive_flag, create_date, created_by,
				modified_date, modified_by, authorized_date, authorized_by);
		return obj;
	}

	public CustInfo() {
		super();
	}
	

	private String customer_code;
	private String customer_pincode;
	private String contact_no;
	private String customer_name;
	private String customer_address1;
	private String customer_address2;
	private String email_address;
	private String primary_contact_person;
	private String record_status;
	private String active_inactive_flag;
	private String create_date;
	private String created_by;
	private String modified_date;
	private String modified_by;
	private String authorized_date;
	private String authorized_by;

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

	public String getCustomer_pincode() {
		return customer_pincode;
	}

	public void setCustomer_pincode(String customer_pincode) {
		this.customer_pincode = customer_pincode;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address1() {
		return customer_address1;
	}

	public void setCustomer_address1(String customer_address1) {
		this.customer_address1 = customer_address1;
	}

	public String getCustomer_address2() {
		return customer_address2;
	}

	public void setCustomer_address2(String customer_address2) {
		this.customer_address2 = customer_address2;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPrimary_contact_person() {
		return primary_contact_person;
	}

	public void setPrimary_contact_person(String primary_contact_person) {
		this.primary_contact_person = primary_contact_person;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public String getActive_inactive_flag() {
		return active_inactive_flag;
	}

	public void setActive_inactive_flag(String active_inactive_flag) {
		this.active_inactive_flag = active_inactive_flag;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getAuthorized_date() {
		return authorized_date;
	}

	public void setAuthorized_date(String authorized_date) {
		this.authorized_date = authorized_date;
	}

	public String getAuthorized_by() {
		return authorized_by;
	}

	public void setAuthorized_by(String authorized_by) {
		this.authorized_by = authorized_by;
	}

	public CustInfo ret() {
		CustInfo ci = new CustInfo(customer_code, customer_pincode, contact_no,
				customer_name, customer_address1, customer_address2,
				email_address, primary_contact_person, record_status,
				active_inactive_flag, create_date, created_by, modified_date,
				modified_by, authorized_date, authorized_by);
		return ci;
	}
}
