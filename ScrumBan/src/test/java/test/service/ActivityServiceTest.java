package test.service;

import java.util.List;

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
public class ActivityServiceTest {

	@Autowired
	private UserService uService;

	@Autowired
	private ActivityService aService;

	@Autowired
	private ProjectService pService;

	@Autowired
	private StatusService sService;

	private UserModel user;

	private ProjectModel project;

	@Before
	public void setUP() {
		this.user = new UserModel("User Edit", "user@edit.com", "123456");
		this.uService.insert(this.user);
		Assert.assertNotNull(this.user.getId());

		this.project = new ProjectModel("Project Test", "Some project desc", this.user);
		this.pService.insert(this.project);
		Assert.assertNotNull(this.project.getId());
	}

	@After
	public void setDown() {
		this.pService.delete(this.project);
		this.uService.delete(this.user);
	}

	@Test
	public void testCreatActivity() {
		ActivityModel activity = new ActivityModel("Test create activity", "some text description", this.user);
		try {
			List<StatusModel> status = this.sService.getAllStatus();
			activity.setStatus(status.get(0));// To do

			activity.setProject(this.project);

			this.aService.save(activity);
			Assert.assertNotNull(activity.getId());
			Assert.assertTrue(activity.getId() > 0);
			
		} catch (Exception e) {
			Assert.fail("error creating activity" + activity.toString());
		} finally {
			this.aService.delete(activity);
		}
	}

	@Test
	public void testEditActivity() {
		ActivityModel activity = new ActivityModel("Test create activity", "some text description", this.user);
		try {
			List<StatusModel> status = this.sService.getAllStatus();
			activity.setStatus(status.get(1));// Doing

			activity.setProject(this.project);

			this.aService.save(activity);
			Assert.assertNotNull(activity.getId());

			String newDesc = "New desc";
			activity.setDescription(newDesc);
			this.aService.edit(activity);

			ActivityModel act = this.aService.getById(activity.getId());
			Assert.assertEquals(newDesc, act.getDescription());
		} catch (Exception e) {
			Assert.fail("error editing activity" + activity.toString());
		} finally {
			this.aService.delete(activity);
		}
	}

	@Test
	public void testAssigneActivity() {
		ActivityModel act = this.createAndInsertActivity();

		try {
			act = this.aService.getById(act.getId());
			Assert.assertNull(act.getAssignedUser());
			
			act.setAssignedUser(this.user);
			this.aService.edit(act);
			
			act = this.aService.getById(act.getId());
			Assert.assertNotNull(act.getAssignedUser());
			Assert.assertEquals(this.user.getEmail(), act.getAssignedUser().getEmail());
		} catch (Exception e) {
			Assert.fail("Error assigning activity: " + e.getMessage());
		} finally {
			this.aService.delete(act);
		}
	}
	
	@Test
	public void testChangeAssignedUser() {
		ActivityModel act = this.createAndInsertActivity();
		
		//create a new user
		UserModel newUser = this.createAndInsertUser();

		try {
			//search by the activity
			act = this.aService.getById(act.getId());
			Assert.assertNull(act.getAssignedUser());
			act.setAssignedUser(this.user);
			
			//set the assigend user
			this.aService.edit(act);
			act = this.aService.getById(act.getId());
			Assert.assertNotNull(act.getAssignedUser());
			Assert.assertEquals(this.user.getEmail(), act.getAssignedUser().getEmail());
			
			//set the new assigned user
			act.setAssignedUser(newUser);
			this.aService.edit(act);
			
			//get the activity and verify if changed de asssigned user
			act = this.aService.getById(act.getId());
			Assert.assertNotNull(act.getAssignedUser());
			Assert.assertEquals(newUser.getEmail(), act.getAssignedUser().getEmail());
		} catch (Exception e) {
			Assert.fail("Error assigning activity: " + e.getMessage());
		} finally {
			this.aService.delete(act);
			this.uService.delete(newUser);
		}
	}

	private UserModel createAndInsertUser() {
		UserModel newUser = new UserModel("Flavia I. Carnielli","flavia.carnielli@gmail.com","felipeTeAmo");
		this.uService.insert(newUser);
		return newUser;
	}

	@Test
	public void testGetAllAssignedActivitiesByUser() {
		ActivityModel a1 = this.createAndInsertActivity();
		ActivityModel a2 = this.createAndInsertActivity();
		ActivityModel a3 = this.createAndInsertActivity();
		
		UserModel otherUser = this.createAndInsertUser();

		try {
			//add TWO activiy for this.user and ONE to otherUser
			a1.setAssignedUser(this.user);
			a2.setAssignedUser(this.user);
			a3.setAssignedUser(otherUser);
			this.aService.edit(a1);
			this.aService.edit(a2);
			this.aService.edit(a3);
			
			List<ActivityModel> assignedActivities = this.aService.getAllActivitiesByUserId(this.user.getId());
			Assert.assertNotNull(assignedActivities);
			Assert.assertEquals(2, assignedActivities.size());
			
			List<ActivityModel> othertUserAssignedActivities = this.aService.getAllActivitiesByUserId(otherUser.getId());
			Assert.assertNotNull(othertUserAssignedActivities);
			Assert.assertEquals(1, othertUserAssignedActivities.size());

		} catch (Exception e) {
			Assert.fail("Error getting assigned activities: " + e.getMessage());
		} finally {
			this.aService.delete(a1);
			this.aService.delete(a2);
			this.aService.delete(a3);
		}
	}

	private ActivityModel createAndInsertActivity() {
		ActivityModel activity = new ActivityModel("Test create activity", "some text description", this.user);
		List<StatusModel> status = this.sService.getAllStatus();
		activity.setStatus(status.get(0));// To do
		activity.setProject(this.project);
		this.aService.save(activity);
		Assert.assertNotNull(activity.getId());
		return activity;
	}
}
