package service;

import java.util.Date;
import java.util.List;

import model.ActivityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ActivityDAO;

@Component
public class ActivityService {

	@Autowired
	private ActivityDAO activityDAO;

	public ActivityModel save(ActivityModel activity) {
		activity.setCreatedDate(new Date());
		return (ActivityModel) this.activityDAO.insert(activity);
	}

	public void edit(ActivityModel newActivity) {
		this.activityDAO.update(newActivity);
	}

	public void delete(ActivityModel activity) {
		this.activityDAO.delete(activity);
	}

	public ActivityModel getById(Integer id) {
		return this.activityDAO.getById(id);
	}

	public List<ActivityModel> getAllActivities() {
		return this.activityDAO.getAllActivities();
	}

	public List<ActivityModel> getAllActivitiesByUserId(Integer userId) {
		return this.activityDAO.getAllActivitiesByUserId(userId);
	}
}
