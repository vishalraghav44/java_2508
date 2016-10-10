package com.jcombat.service;

import com.jcombat.bean.UserBean;

public interface ICombatService {
	public abstract boolean authenticateUser(UserBean userBean);
}