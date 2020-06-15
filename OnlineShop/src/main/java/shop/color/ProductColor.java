package shop.color;

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

import shop.category.Category;
import shop.product.Product;
import shop.type.Type;

@Entity
public class ProductColor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productColorId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
	Product product;
	
	
	@OneToMany(mappedBy = "productColor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Color> color;

	
	public ProductColor(){
		
	}

	public ProductColor(Long productColorId, Product product) {
		super();
		this.productColorId = productColorId;

	}

	public Long getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Long productColorId) {
		this.productColorId = productColorId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
}
