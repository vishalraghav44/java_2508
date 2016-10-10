package com.jcombat.dao;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jcombat.bean.UserBean;

public class CombatDAO implements ICombatDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("deprecation")
	public boolean authenticateUser(UserBean userBean){
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForInt("select count(*)" +
				" from login " +
				" where uname = ? and password = ?",
				userBean.getUserId(),userBean.getPassword());
		if(rowcount==1){
			userExists = true;
		}
		return userExists;
	}
}