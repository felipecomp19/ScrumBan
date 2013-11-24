package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Adds a name property to the <code>BaseModel</code>
 * 
 * @author Felipe Teixeira
 *
 */
@MappedSuperclass
public class NamedModel extends BaseModel{

	@Column(name = "txt_name")	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}
}
