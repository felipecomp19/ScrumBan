package viewModel;

import java.util.List;

import model.ActivityModel;
import model.ProjectModel;
import model.StatusModel;
import model.UserModel;

public class ScrumBoardViewModel {

	private ProjectModel project;

	private ActivityModel activity;

	private List<ActivityModel> activities;

	private List<StatusModel> statusList;

	private List<UserModel> userList;

	public List<ActivityModel> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityModel> activities) {
		this.activities = activities;
	}

	public ProjectModel getProject() {
		return project;
	}

	public void setProject(ProjectModel project) {
		this.project = project;
	}

	public ActivityModel getActivity() {
		return activity;
	}

	public void setActivity(ActivityModel activity) {
		this.activity = activity;
	}

	public void setStatusList(List<StatusModel> statusList) {
		this.statusList = statusList;
	}

	public List<StatusModel> getStatusList() {
		return this.statusList;
	}

	public List<UserModel> getUserList() {
		return userList;
	}

	public void setUserList(List<UserModel> userList) {
		this.userList = userList;
	}
}
