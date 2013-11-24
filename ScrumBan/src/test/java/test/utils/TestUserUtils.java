package test.utils;

import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

public class TestUserUtils {
	
	@Autowired
	private UserService uService;
	
	public UserModel createAndInsertUser(String email, String name, String pwd)
	{
		UserModel u = new UserModel(name, email,pwd);
		u = this.uService.insert(u);
		
		return u;
	}
	
}
