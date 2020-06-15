package shop.category;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.global.GlobalAdvice;
import shop.product.Product;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Autowired
	GlobalAdvice globalAdvice;
	
	
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

}
