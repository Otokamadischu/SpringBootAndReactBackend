package shop.product;

import java.io.Serializable;
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

import shop.category.Category;
import shop.color.ProductColor;



@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "categoryId", nullable = false)
	Category category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<ProductColor> productColor;
	
	String name;
	String description;
	int quantity;
	int size;
	double price;
	String path;
	
	public Product() {
		
	}

	public Product(Long productId, Category category, String name, String description, int quantity, int size,
			double price, String path) {
		super();
		this.productId = productId;
		this.category = category;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.size = size;
		this.price = price;
		this.path = path;
	}



	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
}
