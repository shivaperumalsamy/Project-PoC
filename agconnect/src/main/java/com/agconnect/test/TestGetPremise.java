package com.agconnect.test;

import com.agconnect.service.AgConnectServiceImpl;

public class TestGetPremise {

	public static void main(String[] args) {
		AgConnectServiceImpl service = new AgConnectServiceImpl();
		
		System.out.println(service.getPremises());
	}
}
