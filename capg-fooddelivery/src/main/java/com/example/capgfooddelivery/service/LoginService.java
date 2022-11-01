package com.example.capgfooddelivery.service;

import javax.servlet.http.HttpServletRequest;

import com.example.capgfooddelivery.entity.Login;


public interface LoginService {
	public Login signIn(Login login);

	public Login signOut(Login login);

	public boolean checkSession(HttpServletRequest request);

}
