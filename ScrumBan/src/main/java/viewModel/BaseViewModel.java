package viewModel;

import model.UserModel;

public class BaseViewModel {
	
	private UserModel loggedUser;

	public BaseViewModel(UserModel loggedUser) {
		this.loggedUser = loggedUser;
	}

	public UserModel getLoggedUser() {
		return loggedUser;
	}
}
