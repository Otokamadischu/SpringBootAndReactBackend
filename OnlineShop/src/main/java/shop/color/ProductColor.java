package shop.color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductColor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productColorId;
	Long productId;
	Long colorId;
	
	public ProductColor(){
		
	}

	public ProductColor(Long productColorId, Long productId, Long colorId) {
		super();
		this.productColorId = productColorId;
		this.productId = productId;
		this.colorId = colorId;
	}

	public Long getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Long productColorId) {
		this.productColorId = productColorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}
	
}
