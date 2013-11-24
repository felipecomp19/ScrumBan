package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_status")
public class StatusModel extends NamedModel {
	
//	@SuppressWarnings("unused")
//	private static final long serialVersionUID = 1L;
//	
//	@Column(name="txt_description")
//	private String description;
//	
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	@Override
//	public String toString()
//	{
//		return "Descrição:" + this.description;
//	}
}
