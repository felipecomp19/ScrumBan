package dao;

import java.util.List;

import model.ActivityModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import utils.HibernateUtil;

@Component
public class ActivityDAO extends BaseDAO {

	public ActivityModel getById(Integer id) {
		return (ActivityModel) super.getById(id, ActivityModel.class);
	}

	@SuppressWarnings("unchecked")
	public List<ActivityModel> getAllActivities() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		List<ActivityModel> activities = session.createQuery("from ActivityModel").list();

		session.close();

		return activities;
	}

	@SuppressWarnings("unchecked")
	public List<ActivityModel> getAllActivitiesByUserId(Integer userId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		String hql = "FROM ActivityModel a WHERE a.assignedUser.id = :user_id)";
		Query query = session.createQuery(hql);

		query.setParameter("user_id", userId);
		
		List<ActivityModel> activities = query.list();

		session.close();

		return activities;
	}

}
