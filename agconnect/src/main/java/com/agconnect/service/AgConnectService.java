package com.agconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.agconnect.dao.UserDaoImpl;
import com.agconnect.entity.User;

public class AgConnectService {

	@Autowired
	UserDaoImpl userDaoImpl;

	public List<User> getUsers() {		
		return userDaoImpl.getUsers();
	}

}
