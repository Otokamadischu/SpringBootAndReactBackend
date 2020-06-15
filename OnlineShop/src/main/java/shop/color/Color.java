package shop.color;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import shop.product.Product;

@Entity
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long colorId;
	String color;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productColorId", nullable = false)
	ProductColor productColor;
	
	
	public Color() {
		
	}
	
	public Color(Long colorId, String color) {
		super();
		this.colorId = colorId;
		this.color = color;
	}

	
	public Long getColorId() {
		return colorId;
	}
	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
