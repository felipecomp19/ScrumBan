package viewModel;

import java.util.List;

import model.ProjectModel;
import model.UserModel;

public class DashBoardViewModel extends BaseViewModel{
	
	public DashBoardViewModel(UserModel loggedUser) {
		super(loggedUser);
	}

	private List<ProjectModel> projects;

	public List<ProjectModel> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectModel> projects) {
		this.projects = projects;
	}
}
