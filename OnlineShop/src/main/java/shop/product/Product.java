package shop.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productId;
	
	String name;
	String description;
	String type;
	int quantity;
	int size;
	double price;
	
	Long categoryId;
	String path;
	
	public Product() {
		
	}
	
	
	public Product(Long productId, String name, String description, String type, int quantity, int size, double price,
			Long categoryId, String path) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.type = type;
		this.quantity = quantity;
		this.size = size;
		this.price = price;
		this.categoryId = categoryId;
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}






	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
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
	
	
	

	
}
