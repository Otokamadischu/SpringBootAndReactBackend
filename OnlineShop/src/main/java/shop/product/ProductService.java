package shop.product;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.category.CategoryRepository;

@Service
public class ProductService {
	
	@Autowired
	final ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	List<Product> findAll(){
		
		return productRepository.findAll();
	}
	
	List<Product> findByQuantityGreaterThan(int value){
		
		return productRepository.findByQuantityGreaterThan(value);
	}
	
	public Optional<Product> findById(long id) {
		
		return productRepository.findById(id);
	}

	public void save(Product product) {
		
		productRepository.saveAndFlush(product);
	}
	
	public void delete(long id) {
		
		productRepository.deleteById(id);
	}

	public List<Product> findAllByType(String type) {

		return productRepository.findAllByType(type);
	}
	
	public List<Product> findByTypeAndCategoryId(String type, long id){
		
		return productRepository.findByTypeAndCategoryId(type, id);
	}
}
