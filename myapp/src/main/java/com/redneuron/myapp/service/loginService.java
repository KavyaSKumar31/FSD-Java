package com.redneuron.myapp.service;

import com.redneuron.myapp.model.User;

public class loginService {
	private String username;
	private String password;
public boolean login(String username,String password) {
	
	if(username.equals("dummy")&&password.equals("dummy")) {
		
		return true;
	}else {
		
		return false;
	}
	
}
}
