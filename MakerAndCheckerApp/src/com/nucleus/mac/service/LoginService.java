// 3. control
package com.nucleus.mac.service;

import java.util.List;

import com.nucleus.mac.dao.CustInfo;
import com.nucleus.mac.dao.LoginDao;
import com.nucleus.mac.dao.LoginDaoInter;
import com.nucleus.mac.validation.Validation;


public class LoginService {
	LoginDaoInter ldi= new LoginDao();
		public String service(String username, String password) {
			
			
			
			String x = ldi.validate(username, password); // controll goes to validate method of login DAO
			System.out.println("output.... "+ x);
			
			return x;  // returning this value to doGet method of login servlet
		}
		
		public void add(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by){
			
			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
		Validation validation=new Validation();
		validation.isCustomerValid(custinfo);
			System.out.println("validation called");
		ldi.add(x);
			
		}
		
		public void delete(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by){
			
			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
			
			ldi.delete(x);

		}
		
		public List<CustInfo> search(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by){
			
			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
			
			List<CustInfo> list= ldi.search(x);
		
		return list;
		
		}
		
		public List<CustInfo> searchall(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by){
			
			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
			
			List<CustInfo> arrlist= ldi.searchall(x);
		
		return arrlist;
		}
		
		public String update(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by){
			
			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
			
			String ack = ldi.update(x);
			return ack;
}

		public void authorize(String customer_code,String customer_pincode,String contact_no,
				String customer_name,String customer_address1,String customer_address2,
				String email_address,String primary_contact_person,String record_status,
				String active_inactive_flag,String create_date,String created_by,String modified_date,
				String modified_by,String authorized_date,String authorized_by) {

			CustInfo custinfo=new CustInfo(customer_code,customer_pincode,contact_no,customer_name,customer_address1,
					customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,
					create_date,created_by,modified_date,modified_by,authorized_date,authorized_by);
				
			CustInfo x=custinfo.ret();
			ldi.authorize(x);
		}
}