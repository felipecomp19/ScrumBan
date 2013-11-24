package dao;

import java.util.List;

import model.UserModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import utils.HibernateUtil;

@Component
public class UserDAO extends BaseDAO{
	
	@SuppressWarnings("unchecked")
	public List<UserModel> getAllUsers() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        List<UserModel> users = session.createQuery("from UserModel").list();
        
        session.close();
        return users;
	}

	public UserModel getById(Integer id) {
		return  (UserModel) super.getById(id, UserModel.class);
	}

}
