package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="tb_project")
public class ProjectModel extends BaseModel {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Column(name = "txt_title")
	private String title;
	
	@Column(name = "txt_description")
	private String description;
	 
	@ManyToOne(optional=false, fetch= FetchType.EAGER)
	private UserModel createdByUser;
	
	@Column(name="dt_createdDate")
	private Date createdOn;
	 
	@OneToMany(mappedBy="project", fetch= FetchType.EAGER)
	private List<ActivityModel> activities;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_project_member", joinColumns = { 
			@JoinColumn(name = "project_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", 
					nullable = false, updatable = false) })
	private Set<UserModel> members;

	public ProjectModel()
	{
		this.createdOn = new Date(System.currentTimeMillis());
		this.activities = new ArrayList<ActivityModel>();
	}
	
	public ProjectModel(String title, String desc) {
		this();
		this.title = title;
		this.description = desc;
	}
	
	public ProjectModel(String title, String description, UserModel createdByUser) 
	{
		this(title,description);
		this.createdByUser = createdByUser;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserModel getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(UserModel createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<ActivityModel> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityModel> activities) {
		this.activities = activities;
	}
	
	public void addActivity(ActivityModel activity)
	{
		if(this.activities == null)
			this.activities = new ArrayList<ActivityModel>();
		this.activities.add(activity);
	}
	
	public Set<UserModel> getMembers() {
		return members;
	}

	public void setMembers(Set<UserModel> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "[Project] ID: " + this.id + " Title: " + this.title + " Desc: " + this.description;
	}
}
