package test.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ActivityModel;
import model.ProjectModel;
import model.StatusModel;
import model.UserModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.ActivityService;
import service.ProjectService;
import service.StatusService;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-servlet.xml" })
public class ProjectServiceTest {

	@Autowired
	private ProjectService pService;

	@Autowired
	private UserService uService;

	@Autowired
	private ActivityService aService;

	@Autowired
	private StatusService sService;

	private UserModel user;

	@Before
	public void setUP() {
		this.user = new UserModel("User Edit", "user@edit.com", "123456");
		this.uService.insert(user);
	}

	@After
	public void setDown() {
		this.uService.delete(this.user);
	}

	@Test
	public void testCreateProject() {
		ProjectModel project = new ProjectModel("Project Test", "Some project desc", this.user);
		try {
			Set<UserModel> members = new HashSet<UserModel>();
			members.add(this.user);
			project.setMembers(members);

			this.pService.insert(project);
			Assert.assertNotNull(project.getId());
		} catch (Exception e) {
			Assert.fail("Error creating project: " + project.toString());
		} finally {
			this.pService.delete(project);
		}
	}

	@Test
	public void testGetAllProjectActivities() {
		ProjectModel project = new ProjectModel("Project Test", "Some project desc", this.user);

		List<ActivityModel> actCreated = new ArrayList<ActivityModel>();
		try {
			this.pService.insert(project);
			actCreated = this.insertActivities(project);

			ProjectModel p = this.pService.getById(project.getId());
			Assert.assertNotNull(p.getActivities());
			Assert.assertEquals(actCreated.size(), p.getActivities().size());
		} catch (Exception e) {
			Assert.fail("Error getting all project's activities: " + project.toString() + " [exception]: " + e.getMessage());
		} finally {
			for (ActivityModel activityModel : actCreated) {
				this.aService.delete(activityModel);
			}
			this.pService.delete(project);
		}
	}

	@Test
	public void testGetAllUserProjects() {
		ProjectModel project = this.createAndInsertProject();
		ProjectModel project2 = this.createAndInsertProject();
		try {
			Set<ProjectModel> userProjects = this.pService.getAllUserProjects(this.user);
			Assert.assertNotNull(userProjects);
			Assert.assertEquals(2,	userProjects.size());
		} catch (Exception e) {
			Assert.fail("Error getting all user projects: " + e.getMessage());
		} finally {
			this.pService.delete(project);
			this.pService.delete(project2);
		}

	}
	private ProjectModel createAndInsertProject() {
		ProjectModel project = new ProjectModel("Project Test", "Some project desc", this.user);
		Set<UserModel> members = new HashSet<UserModel>();
		members.add(this.user);
		project.setMembers(members);
		
		this.pService.insert(project);
		
		return project;
	}

	private List<ActivityModel> insertActivities(ProjectModel project) {
		List<ActivityModel> result = new ArrayList<ActivityModel>();

		ActivityModel activity1 = createActivity(project);
		ActivityModel activity2 = createActivity(project);

		result.add(activity1);
		result.add(activity2);

		return result;
	}

	private ActivityModel createActivity(ProjectModel project) {
		List<StatusModel> status = this.sService.getAllStatus();
		ActivityModel activity = new ActivityModel("Test create activity", "some text description", this.user);
		activity.setProject(project);
		activity.setStatus(status.get(0));// To do
		this.aService.save(activity);
		return activity;
	}
}
