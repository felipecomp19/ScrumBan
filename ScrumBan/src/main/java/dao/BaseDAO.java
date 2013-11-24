package dao;

import model.BaseModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtil;

public abstract class BaseDAO {

	public BaseModel insert(BaseModel model) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Integer id = (Integer) session.save(model);
		model.setId(id);

		session.getTransaction().commit();

		session.close();

		return model;
	}

	public void delete(BaseModel model) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.delete(model);

		session.getTransaction().commit();

		session.close();
	}

	public BaseModel update(BaseModel model) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.merge(model);

		session.getTransaction().commit();

		session.close();
		return model;
	}

	protected BaseModel getById(Integer id, Class<?> modelClass) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		BaseModel model = (BaseModel) session.get(modelClass, id);

		session.close();
		return model;
	}

}
