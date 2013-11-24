package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ProjectModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import utils.HibernateUtil;

@Component
public class ProjectDAO extends BaseDAO {

	public ProjectModel getById(Integer id) {
		return (ProjectModel) super.getById(id, ProjectModel.class);
	}

	@SuppressWarnings("unchecked")
	public List<ProjectModel> getAll() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		List<ProjectModel> projects = session.createQuery("from ProjectModel").list();

		session.close();

		return projects;
	}

	@SuppressWarnings("unchecked")
	public Set<ProjectModel> getAllUserProjects(Integer user_id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		String hql = "FROM ProjectModel p INNER JOIN p.members m WHERE m.id = :user_id";
		Query query = session.createQuery(hql);

		query.setParameter("user_id", user_id);
		
		Set<ProjectModel> projects = new HashSet<ProjectModel>(query.list());

		session.close();

		return projects;
	}
}
