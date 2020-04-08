package shop.size;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ColorSize {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long colorSizeId;
	Long sizeId;
	Long productColorId;
	int quantity;
	
	public ColorSize() {
		
	}

	public ColorSize(Long colorSizeId, Long sizeId, Long productColorId, int quantity) {
		super();
		this.colorSizeId = colorSizeId;
		this.sizeId = sizeId;
		this.productColorId = productColorId;
		this.quantity = quantity;
	}

	public Long getColorSizeId() {
		return colorSizeId;
	}

	public void setColorSizeId(Long colorSizeId) {
		this.colorSizeId = colorSizeId;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public Long getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Long productColorId) {
		this.productColorId = productColorId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
