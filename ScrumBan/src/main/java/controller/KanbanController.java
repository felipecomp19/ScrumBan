package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.ActivityModel;
import model.ProjectModel;
import model.StatusModel;
import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.ActivityService;
import service.ProjectService;
import service.StatusService;
import validator.ActivityValidator;

/**
 * @author Felipe Teixeira
 * 
 */
@Controller
@SessionAttributes("activity")
public class KanbanController extends BaseController {

	private final ActivityService activityService;
	private final ProjectService projectService;
	private final StatusService statusService;

	@Autowired
	public KanbanController(ActivityService activityService, ProjectService projectService, StatusService statusService) {
		this.activityService = activityService;
		this.projectService = projectService;
		this.statusService = statusService;
	}

//	@ModelAttribute("activities")
//	public Collection<ActivityModel> populateActiviesList() {
//		System.out.println("[TODO] get activies by project");
//		return this.activityService.getAllActivities();
//	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@RequestMapping(value = "/kanban/{projectId}/activities", method = RequestMethod.GET)
	public String initKanban(@PathVariable("projectId") Integer projectId, Map<String, Object> model)
	{
		ActivityModel activity = new ActivityModel();
		ProjectModel project = this.projectService.getById(projectId);
		List<UserModel> members = new ArrayList<UserModel>(project.getMembers());
		List<StatusModel> status = this.statusService.getAllStatus();
		
		activity.setProject(project);
		
		model.put("activity", activity);
		model.put("project", project);
		model.put("members", members);
		model.put("status", status);
		
		return "kanban/kanban";
	}
	
	@RequestMapping(value = "/kanban/{projectId}/activities", method = RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("activity") ActivityModel newActivity, BindingResult result, SessionStatus status) {
		new ActivityValidator().validate(newActivity,result);
		if(result.hasErrors()){
			return "kanban/kanban";
		}else{
			newActivity.setCreatedByUser(this.getLoggedUser());
			this.activityService.save(newActivity);
			status.setComplete();
			return "kanban/kanban";
		}
	}
}
