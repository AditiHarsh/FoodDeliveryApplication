package com.example.Restaurant.service;

import javax.servlet.http.HttpServletRequest;

import com.example.Restaurant.entities.Login;

public interface LoginService {
	public Login signIn(Login login);

	public Login signOut(Login login);

	public boolean checkSession(HttpServletRequest request);
}
