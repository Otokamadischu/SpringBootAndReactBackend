package shop.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import shop.product.*;
import shop.type.Type;


@Entity
public class Category implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long categoryId;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeId", nullable = false)
    Type type;
	

	@OneToMany(mappedBy="category", 
			fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Product> product;
	
	String name;
	String description;
	//picture
	Boolean active;
	
	public Category() {
		
	}
	
	public Category(Long categoryId, Type type, String name, String description, Boolean active) {
		super();
		this.categoryId = categoryId;
		this.type = type;

		this.name = name;
		this.description = description;
		this.active = active;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
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
	
	
	
	

}
