package com.jcombat.dao;

import javax.sql.DataSource;

import com.jcombat.bean.UserBean;

public interface ICombatDAO {
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean authenticateUser(UserBean userBean);
}