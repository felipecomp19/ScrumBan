package controller;

import javax.servlet.http.HttpServletRequest;

import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;
import viewModel.UserViewModel;

@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users(HttpServletRequest request) {
		UserViewModel userVM = new UserViewModel();
		userVM.setUserList(this.uService.getAllUsers());

		return new ModelAndView("user/user", "userVM", userVM);
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request)
	{
		UserModel user = getVO(request);
		
		if(user.getId() == null)
			this.uService.insert(user);
		else
			this.uService.edit(user);
		
		return "redirect:users.html";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(Integer id)
	{
		UserViewModel userVM = new UserViewModel();
		if(id != null)
			userVM.setUser(this.uService.getById(id));
		
		userVM.setUserList(this.uService.getAllUsers());
		
		return new ModelAndView("user/user", "userVM", userVM);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(Integer id)
	{
		if(id != null){
			UserModel user = new UserModel();
			user.setId(id);
			this.uService.delete(user);
		}
		
		return "redirect:users.html";
	}

	private UserModel getVO(HttpServletRequest request) {
		Integer id = new Integer(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		UserModel user = new UserModel(name,email,pwd);
		user.setId(id);
		return user;
	}

}

