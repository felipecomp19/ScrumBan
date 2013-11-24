package controller;

import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	protected UserService uService;
	
	private UserModel loggedUser;
	
	protected UserModel getLoggedUser() {
		this.loggedUser = this.uService.getById(new Integer(1));
		
		System.out.println("ALERT!!! YOU NEED TO GET THE LOGGED USER");
		
		return this.loggedUser;
	}
}
