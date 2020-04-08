package shop.size;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long sizeId;
	String size;
	
	public Size() {
		
	}
	
	public Size(Long sizeId, String size) {
		super();
		this.sizeId = sizeId;
		this.size = size;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	
	
}
