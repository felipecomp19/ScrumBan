package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class UserModel extends BaseModel{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Column(name = "txt_name")
	private String name;

	@Column(name = "txt_email")
	private String email;

	@Column(name = "txt_password")
	private String password;
	
	@ManyToMany(mappedBy = "members")
	private Set<ProjectModel> projects;

	// Constructors
	public UserModel() {	}
	
	public UserModel(String name, String email,String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ProjectModel> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectModel> projects) {
		this.projects = projects;
	}

	@Override
	public String toString()
	{
		return "[User] name:" + this.name + "; e-mail:" + this.email + "; login:" + ";";
	}
}
