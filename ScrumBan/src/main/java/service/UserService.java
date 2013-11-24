package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.UserModel;
import dao.UserDAO;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public UserModel insert(UserModel user) {
		return (UserModel) this.userDAO.insert(user);
	}

	public void edit(UserModel newUser) {
		this.userDAO.update(newUser);
	}

	public void delete(UserModel user) {
		this.userDAO.delete(user);
	}

	public List<UserModel> getAllUsers() {

		return this.userDAO.getAllUsers();
	}

	public UserModel getById(Integer id) {
		return this.userDAO.getById(id);
	}
}
