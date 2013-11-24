package service;

import java.util.List;
import java.util.Set;

import model.ProjectModel;
import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ProjectDAO;

@Component
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	public ProjectModel insert(ProjectModel project)
	{
		return (ProjectModel) this.projectDAO.insert(project);
	}
	
	public ProjectModel getById(Integer id) {
		return this.projectDAO.getById(id);
	}

	public void delete(ProjectModel project) {
		this.projectDAO.delete(project);
	}

	public List<ProjectModel> getAll() {
		return this.projectDAO.getAll();
	}

	public void delete(Integer id) {
		ProjectModel project = new ProjectModel();
		project.setId(id);
		this.projectDAO.delete(project);
	}

	public Set<ProjectModel> getAllUserProjects(UserModel user) {
		return this.projectDAO.getAllUserProjects(user.getId());
	}
	
	
}
