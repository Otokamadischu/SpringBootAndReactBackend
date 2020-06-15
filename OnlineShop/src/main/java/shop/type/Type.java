package shop.type;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import shop.category.Category;


@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long typeId;
	
	String name;
	String description;
	//picture
	Boolean active;

	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Category> category;


	
	public Type() {
		
	}
	
	



	public Type(Long typeId, String name, String description, Boolean active) {
		
		super();
		this.typeId = typeId;
		this.name = name;
		this.description = description;
		this.active = active;
	}


	public Long getTypeId() {
		return typeId;
	}


	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Set<Category> getCategory() {
		return category;
	}


	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
}
