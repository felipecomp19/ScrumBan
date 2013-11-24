package dao;

import java.util.List;

import model.StatusModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import utils.HibernateUtil;

@Component
public class StatusDAO extends BaseDAO {

	public StatusModel getById(Integer id) {
		return (StatusModel) super.getById(id, StatusModel.class);	
	}
	
	public List<StatusModel> getAllStatus()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		@SuppressWarnings("unchecked")
		List<StatusModel> status = session.createQuery("from StatusModel").list();

		session.close();

		return status;
	}

}
