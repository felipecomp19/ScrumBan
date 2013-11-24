package service;

import java.util.List;

import model.StatusModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.StatusDAO;

@Component
public class StatusService {
	
	@Autowired
	private StatusDAO statusDAO;

	public StatusModel getById(Integer id)
	{
		return this.statusDAO.getById(id);
	}
	
	public List<StatusModel> getAllStatus()
	{
		return this.statusDAO.getAllStatus();
	}
}
