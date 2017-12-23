package com.agconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agconnect.dao.PremiseDaoImpl;
import com.agconnect.dao.UserDaoImpl;
import com.agconnect.entity.Premise;

public class AgConnectServiceImpl implements AgConnectService {

	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	PremiseDaoImpl premiseDaoImpl;
	
	public List<Premise> getPremises() {
		return premiseDaoImpl.getPremises();
	}

}
