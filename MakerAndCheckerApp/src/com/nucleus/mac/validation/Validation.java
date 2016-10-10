package com.nucleus.mac.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nucleus.mac.dao.CustInfo;

public class Validation {
	public static boolean isCustCodeValid(String customer_code) {
		if (customer_code == null || customer_code.length() > 10) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isCustNameValid(String customer_name) {
		if (customer_name.equals("") || customer_name == null || customer_name.length() > 30) {
			return false;
		} else
			return customer_name.matches("^[a-zA-z0-9/w ]*$");
	}

	public static boolean isAddress1Valid(String customer_address1) {
		if (customer_address1.length() > 100 || customer_address1 == null || customer_address1.equals(""))
			return false;
		else
			return customer_address1.matches("^[a-zA-z0-9/w ]*$");
	}

	public static boolean isAddress2Valid(String customer_address2) {
		if (customer_address2.length() > 100)
			return false;
		else
			return customer_address2.matches("^[a-zA-z0-9/w ]*$");
	}

	public static boolean isPincodeValid(long customer_pincode) {
		String str = Long.toString(customer_pincode);
		if (str.length() == 6)
			return true;
		else
			return false;
	}

	public static boolean isEmailValid(String email_address) {
		if (email_address.length() > 100 || email_address == null)
			return false;
		else {
			Pattern p = Pattern
					.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,80}))$");
			Matcher m = p.matcher(email_address);
			return m.matches();
		}
	}

	public static boolean isContactNoValid(Long contact_no) {
		String str = Long.toString(contact_no);
		if (str.length() > 10)
			return false;
		else {
			if (str.length() >= 10 || str.length() <= 20)
				return true;
			else
				return false;
		}
	}

	public static boolean isPrimContPerValid(String primary_contact_person) {
		if (primary_contact_person == null || primary_contact_person.length() > 100)
			return false;
		else
			return true;
	}

	public static boolean isREQStatusValid(String record_status) {
		if (record_status == null || record_status.length() > 1)
			return false;
		else
			return record_status.matches("[NMDARnmdar]");
	}

	public static boolean isFlagValid(String active_inactive_flag) {
		if (active_inactive_flag == null || active_inactive_flag.length() > 1)
			return false;
		else
			return active_inactive_flag.matches("[AIai]");
	}

	public static boolean isCreatedDateValid(String create_date) {
		if (create_date == null)
			return false;
		else
			return create_date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}");
	}

	public static boolean isCreatedByValid(String created_by) {
		if (created_by == null || created_by.length() > 30)
			return false;
		else
			return true;
	}

	public static boolean isModDateValid(String modified_date) {
		if ("".equals(modified_date))
			return true;
		else
			return modified_date.matches("[0-9]{2}/[a-zA-Z]{3}/[0-9]{4}");

	}

	public static boolean isModByValid(String modified_by) {
		if (modified_by.length() <= 30 || " ".equals(modified_by))
			return true;
		else
			return false;
	}
	public static boolean isAuthDateValid(String authorized_date) {
		if ("".equals(authorized_date))
			return true;
		else
			return authorized_date.matches("[0-9]{2}/[a-zA-Z]{3}/[0-9]{4}");

	}
	public static boolean isAuthByValid(String authorized_by) {
		if (authorized_by.length() <= 30 || " ".equals(authorized_by))
			return true;
		else
			return false;
	}
	
	public boolean isCustomerValid(CustInfo ci) {
		if (!Validation.isCustCodeValid(ci.getCustomer_code()))
			return false;
		if (!Validation.isCustNameValid(ci.getCustomer_name()))
			return false;
		if (!Validation.isAddress1Valid(ci.getCustomer_address1()))
			return false;
		if (!Validation.isAddress2Valid(ci.getCustomer_address2()))
			return false;
		if (!Validation.isPincodeValid(Long.parseLong(ci.getCustomer_pincode())))
			return false;
		if (!Validation.isEmailValid(ci.getEmail_address()))
			return false;
		if (!Validation.isContactNoValid(Long.parseLong(ci.getContact_no())))
			return false;
		if (!Validation.isPrimContPerValid(ci.getPrimary_contact_person()))
			return false;
		if (!Validation.isREQStatusValid(ci.getRecord_status()))
			return false;
		if (!Validation.isFlagValid(ci.getActive_inactive_flag()))
			return false;
		if (!Validation.isCreatedDateValid(ci.getCreate_date()))
			return false;
		if (!Validation.isCreatedByValid(ci.getCreated_by()))
			return false;
		if (!Validation.isModDateValid(ci.getModified_date()))
			return false;
		if (!Validation.isModByValid(ci.getModified_by()))
			return false;
		if (!Validation.isAuthDateValid(ci.getAuthorized_date()))
			return false;
		if (!Validation.isAuthByValid(ci.getAuthorized_by()))
			return false;
		return true;
		
	}

}
