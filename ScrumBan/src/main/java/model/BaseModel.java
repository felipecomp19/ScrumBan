package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object with an id property. 
 * Used as a base class for objects needing this property.
 *
 * @author Felipe Teixeira
 * 
 */
@MappedSuperclass
public class BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isNew() {
    return (this.id == null);
	}
}
