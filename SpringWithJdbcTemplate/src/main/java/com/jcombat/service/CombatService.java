package com.jcombat.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jcombat.bean.UserBean;
import com.jcombat.dao.ICombatDAO;

public class CombatService implements ICombatService {

	@Autowired
	private ICombatDAO combatDAO;

	public boolean authenticateUser(UserBean userBean){
		return combatDAO.authenticateUser(userBean);
	}
}