package controller;

import javax.servlet.http.HttpServletRequest;

import model.ProjectModel;
import model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.ProjectService;
import viewModel.DashBoardViewModel;

@Controller
public class DashBoardController extends BaseController{

	@Autowired
	private ProjectService pService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request)
	{
		DashBoardViewModel dashVM = new DashBoardViewModel(this.getLoggedUser());
		dashVM.setProjects(this.pService.getAll());
		
		return new ModelAndView("dashboard/dashboardView", "dashVM", dashVM);
	}
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public String saveProject(HttpServletRequest request)
	{
		ProjectModel projectVO = this.getVO(request);
		
		UserModel loggedUser = this.getLoggedUser();
		projectVO.setCreatedByUser(loggedUser);
		
		this.pService.insert(projectVO);
		
		return "redirect:dashboard.html";
	}
	
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public String deleteProject(Integer id)
	{
		if(id != null)
			this.pService.delete(id);
		
		return "redirect:dashboard.html";
	}

	private ProjectModel getVO(HttpServletRequest request) {
		String title = request.getParameter("name");
		String desc = request.getParameter("desc");

		ProjectModel project = new ProjectModel(title, desc);
		return project;
	}
	
}
