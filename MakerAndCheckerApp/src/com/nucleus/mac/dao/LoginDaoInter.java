// 4. control
package com.nucleus.mac.dao;

import java.util.List;


	public interface LoginDaoInter {
		public String validate(String uname, String pwd);
		public void add(CustInfo custinfo);
		public void delete(CustInfo custinfo);
		public List<CustInfo> search(CustInfo custinfo);
		public String update(CustInfo custinfo);
		public List<CustInfo> searchall(CustInfo custinfo);
		public void authorize(CustInfo custinfo);
		
	}

