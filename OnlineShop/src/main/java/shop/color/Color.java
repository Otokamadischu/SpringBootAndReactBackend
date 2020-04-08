package shop.color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long colorId;
	String color;
	
	
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
