package viewModel;

import java.util.List;

import model.UserModel;

public class UserViewModel {
	
	public List<UserModel> userList;
	
	public UserModel user;
	
	public UserViewModel()
	{
		this.user = new UserModel();
	}

	public List<UserModel> getUserList() {
		return userList;
	}

	public void setUserList(List<UserModel> userList) {
		this.userList = userList;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
}
