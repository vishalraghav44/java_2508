// 5. controll

package com.nucleus.mac.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nucleus.mac.factory.DbManager;

public class LoginDao implements LoginDaoInter {
	String  status=null;
	public String validate(String uname, String pwd) {
		String u = uname;
		String p = pwd;
		int flag = 0;
		String role = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			DbManager connect = new DbManager();
			connect.getConnection();

			pstmt = connect.conn
					.prepareStatement("select * from mac_login where  username=? and password =?");
			pstmt.setString(1, u);
			pstmt.setString(2, p);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				role = rs.getString("role");
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1)
			return role;
		else
			return null;
	}
	@Override
	public void add(CustInfo obj) {
		try {
			DbManager connect = new DbManager();
			connect.getConnection();

			String query = "insert into mac_temp(customer_id,customer_code,customer_pincode,contact_no,customer_name,customer_address1,customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by)values(SEQ_mac_temp.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connect.conn.prepareStatement(query);
			
			pstmt.setString(1, obj.getCustomer_code());
			pstmt.setLong(2, Long.parseLong(obj.getCustomer_pincode()));
			pstmt.setLong(3, Long.parseLong(obj.getContact_no()));
			pstmt.setString(4, obj.getCustomer_name());
			pstmt.setString(5, obj.getCustomer_address1());
			pstmt.setString(6, obj.getCustomer_address2());
			pstmt.setString(7, obj.getEmail_address());
			pstmt.setString(8, obj.getPrimary_contact_person());
			pstmt.setString(9, obj.getRecord_status());
			pstmt.setString(10, obj.getActive_inactive_flag());
			pstmt.setString(11, obj.getCreate_date());
			pstmt.setString(12, obj.getCreated_by());
			pstmt.setString(13, obj.getModified_date());
			pstmt.setString(14, obj.getModified_by());
			pstmt.setString(15, obj.getAuthorized_date());
			pstmt.setString(16, obj.getAuthorized_by());

			pstmt.executeUpdate();
			System.out.println("Recorded Added To Database");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	@Override
	public void delete(CustInfo obj) {
		try {
			DbManager connect = new DbManager();
			connect.getConnection();

			
			String query = "delete from mac_temp where customer_code=?";
			
			PreparedStatement pstmt = connect.conn.prepareStatement(query);

			pstmt.setString(1, obj.getCustomer_code());
		
			pstmt.executeUpdate();
			System.out.println("Recorded Deleted From Database.....");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<CustInfo> search(CustInfo obj) {
		List<CustInfo> list= new ArrayList<CustInfo>();
		try {
			
			DbManager connect = new DbManager();
			connect.getConnection();
			PreparedStatement pstmt = connect.conn.prepareStatement("Select * from mac_temp where customer_code like ?");
			pstmt.setString(1, obj.getCustomer_code());
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
			
				
				obj.setCustomer_code(resultSet.getString("customer_code"));
				obj.setCustomer_name(resultSet.getString("customer_name"));
				obj.setCustomer_address1(resultSet.getString("customer_address1"));
				obj.setCustomer_address2(resultSet.getString("customer_address2"));
				obj.setCustomer_pincode(String.valueOf(resultSet.getLong("customer_pincode")));
				obj.setEmail_address(resultSet.getString("email_address"));
				obj.setContact_no(String.valueOf(resultSet.getLong("Contact_no")));
				obj.setPrimary_contact_person(resultSet.getString("primary_contact_person"));
				obj.setRecord_status(resultSet.getString("record_status"));
				obj.setActive_inactive_flag(resultSet.getString("active_inactive_flag"));
				obj.setCreate_date(resultSet.getString("create_date"));
				obj.setCreated_by(resultSet.getString("created_by"));
				obj.setModified_date(resultSet.getString("modified_date"));
				obj.setModified_by(resultSet.getString("modified_by"));
				obj.setAuthorized_date(resultSet.getString("authorized_date"));
				obj.setAuthorized_by(resultSet.getString("authorized_by"));
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public String update(CustInfo custinfo) {
			try {
				DbManager connect = new DbManager();
				connect.getConnection();
				PreparedStatement pstmt = connect.conn.prepareStatement("Select * from mac_temp where customer_code = ?");
				pstmt.setString(1, custinfo.getCustomer_code());
				
				
				ResultSet resultSet = pstmt.executeQuery();
				
				while (resultSet.next()) {
					
				CustInfo custinfo1=new CustInfo();
				PreparedStatement ps = connect.conn.prepareStatement("update mac_temp set customer_code=? , customer_name=?, customer_address1=?, customer_address2=?,customer_pincode=?,email_address=?,contact_no=?,primary_contact_person=?,record_status=?,active_inactive_flag=? where customer_code=?");
				ps.setString(1,custinfo1.getCustomer_code());
				System.out.println(custinfo1.getCustomer_code());
				ps.setString(2,custinfo1.getCustomer_name());
				System.out.println(custinfo1.getCustomer_name());
				
				ps.setString(3,custinfo1.getCustomer_address1());
			    ps.setString(4,custinfo.getCustomer_address2());
				ps.setLong(5,Long.parseLong(custinfo.getCustomer_pincode()));
				ps.setString(6,custinfo.getEmail_address());
				ps.setLong(7,Long.parseLong(custinfo.getContact_no()));
				ps.setString(8,custinfo.getPrimary_contact_person());
				ps.setString(9,custinfo.getRecord_status());
				ps.setString(10,custinfo.getActive_inactive_flag());
				ps.setString(11,custinfo.getCustomer_code());
				
				int row = ps.executeUpdate();
				if (row > 0)
					status = "Row Updated";
				else
					status = "Not Updated";

			connect.conn.close();
			}
				}catch (Exception e) {
				e.printStackTrace();
			
			
		}
			return status;
	}
	@Override
	public List<CustInfo> searchall(CustInfo obj) {
	
		List<CustInfo> arrlist= new ArrayList<CustInfo>();
		CustInfo custinfo = new CustInfo();
		try {
			
			DbManager connect = new DbManager();
			connect.getConnection();
			PreparedStatement pstmt = connect.conn.prepareStatement("Select * from mac_temp");
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				String customer_code= resultSet.getString("customer_code");
				String	customer_name=	resultSet.getString("customer_name");
				String customer_address1=	resultSet.getString("customer_address1");
				String customer_address2=	resultSet.getString("customer_address2");
				String customer_pincode=	resultSet.getString("customer_pincode");
				String	email_address=resultSet.getString("email_address");
				String	contact_no=resultSet.getString("Contact_no");
				String primary_contact_person=	resultSet.getString("primary_contact_person");
				String record_status=resultSet.getString("record_status");
				String	active_inactive_flag=resultSet.getString("active_inactive_flag");
				String create_date=	resultSet.getString("create_date");
				String created_by=resultSet.getString("created_by");
				String modified_date =resultSet.getString("modified_date");
				String modified_by=resultSet.getString("modified_by");
				String authorized_date=resultSet.getString("authorized_date");
				String authorized_by= resultSet.getString("authorized_by");
				
				custinfo=new CustInfo(customer_code, customer_pincode,
						contact_no, customer_name, customer_address1,
						customer_address2, email_address, primary_contact_person,
						record_status, active_inactive_flag, create_date, created_by,
						modified_date, modified_by, authorized_date, authorized_by);
				
				arrlist.add(custinfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrlist;
	}
	@Override
	public void authorize(CustInfo obj) {
		try {
			DbManager connect = new DbManager();
			connect.getConnection();

			String query = "insert into mac_perm(customer_id,customer_code,customer_pincode,contact_no,customer_name,customer_address1,customer_address2,email_address,primary_contact_person,record_status,active_inactive_flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by)values(SEQ_mac_perm.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connect.conn.prepareStatement(query);
			
			pstmt.setString(1, obj.getCustomer_code());
			pstmt.setLong(2, Long.parseLong(obj.getCustomer_pincode()));
			pstmt.setLong(3, Long.parseLong(obj.getContact_no()));
			pstmt.setString(4, obj.getCustomer_name());
			pstmt.setString(5, obj.getCustomer_address1());
			pstmt.setString(6, obj.getCustomer_address2());
			pstmt.setString(7, obj.getEmail_address());
			pstmt.setString(8, obj.getPrimary_contact_person());
			pstmt.setString(9, obj.getRecord_status());
			pstmt.setString(10, obj.getActive_inactive_flag());
			pstmt.setString(11, obj.getCreate_date());
			pstmt.setString(12, obj.getCreated_by());
			pstmt.setString(13, obj.getModified_date());
			pstmt.setString(14, obj.getModified_by());
			pstmt.setString(15, obj.getAuthorized_date());
			pstmt.setString(16, obj.getAuthorized_by());

			pstmt.executeUpdate();
			System.out.println("Record Authorised and Added To Permanent Database");

		} catch (Exception e) {
			System.out.println(e);
		}

		
	}
		
	}
	

