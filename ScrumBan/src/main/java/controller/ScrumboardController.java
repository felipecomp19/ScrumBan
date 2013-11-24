package controller;

import javax.servlet.http.HttpServletRequest;

import model.ActivityModel;
import model.ProjectModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.ProjectService;
import service.StatusService;
import service.UserService;
import viewModel.ScrumBoardViewModel;

@Controller
public class ScrumboardController extends BaseController{

	@Autowired
	private ProjectService pService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private StatusService sService;
	
	@RequestMapping(value = "/scrumboard", method = RequestMethod.GET, params="projectId")
	public ModelAndView scrumboard(HttpServletRequest request)
	{
		Integer projectId = new Integer(request.getParameter("projectId"));
		
		ProjectModel project = this.pService.getById(projectId);
		
		ScrumBoardViewModel vm = new ScrumBoardViewModel();
		vm.setProject(project);
		vm.setActivity(new ActivityModel());
		vm.setStatusList(this.sService.getAllStatus());
		vm.setUserList(this.uService.getAllUsers());
		System.out.println("[TODO] Get only de members of the project");
		
		return new ModelAndView("scrumboard/scrumboardView", "vm", vm);
	}
	
	@RequestMapping(value = "/scrumboard/saveActivity", method = RequestMethod.POST)
	public String saveActivity(ActivityModel activity)
	{
		System.out.println(activity.toString());
		
		return "redirect:scrumboard.html";
	}
	
}
