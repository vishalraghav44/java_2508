package com.nucleus.mac.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
	
	public class DbManager {
		
		public Connection conn = null;

		public Connection getConnection() {

			String DB_URL = "jdbc:oracle:thin:@finn:1521:orcl";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Connecting to selected database");
				conn = DriverManager.getConnection(DB_URL, "hr", "hr");
				System.out.println("Connected database successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	

}
