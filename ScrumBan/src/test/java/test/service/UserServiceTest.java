package test.service;

import model.UserModel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-servlet.xml" }) 
public class UserServiceTest {

	@Autowired
	private UserService uService;// = new UserService();

	@Test
	public void testCreateUser() {
		UserModel u = new UserModel();

		u.setName("Felipe");
		u.setEmail("felipecomp19@gmail.com");
		u.setPassword("floripa.20");

		UserModel _u = new UserModel();
		try {
			
			this.uService.insert(u);
			
			Assert.assertNotNull(u.getId());
			_u = this.uService.getById(u.getId());
			Assert.assertNotNull(_u);
			
		} catch (Exception e) {
			Assert.fail("error creating user" + u.toString());
		} finally {
			this.uService.delete(_u);
		}
	}
	
	@Test
	public void testEditUser()
	{
		UserModel user = new UserModel("User Edit","user@edit.com","123456");
		
		String newEmail = "novoEmail@edit.com";
		try {
			this.uService.insert(user);
			Assert.assertNotNull(user.getId());
			
			user.setEmail(newEmail);
			this.uService.edit(user);
			
			UserModel uTemp = this.uService.getById(user.getId());
			Assert.assertNotNull(uTemp);
			Assert.assertEquals(newEmail, uTemp.getEmail());
		} catch (Exception e) {
			Assert.fail("error editing user" + user.toString());
		}
		finally
		{
			this.uService.delete(user);
		}
	}
}
