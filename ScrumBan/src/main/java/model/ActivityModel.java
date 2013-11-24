package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_activity")
public class ActivityModel extends BaseModel {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Column(name = "txt_name", nullable = false)
	private String name;

	@Column(name = "txt_description")
	private String description;

	@Column(name = "dt_createdDate", nullable = false)
	private Date createdDate;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UserModel createdByUser;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private StatusModel status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	private ProjectModel project;

	@ManyToOne(fetch = FetchType.EAGER)
	private UserModel assignedUser;

	// Constructors
	public ActivityModel() { }

	public ActivityModel(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}

	public ActivityModel(String name, String description, UserModel createdByUser) {
		this(name, description);
		this.createdByUser = createdByUser;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserModel getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(UserModel createdByUser) {
		this.createdByUser = createdByUser;
	}

	public StatusModel getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}

	public ProjectModel getProject() {
		return project;
	}

	public void setProject(ProjectModel project) {
		this.project = project;
	}
	
	public UserModel getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(UserModel assignedUser) {
		this.assignedUser = assignedUser;
	}

	@Override
	public String toString() {
		return name + " (created on " + this.createdDate + ")" + " Status: " + this.status + " by user: " + this.createdByUser.toString();
	}
}
