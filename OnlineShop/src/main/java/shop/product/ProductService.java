package shop.product;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.category.Category;
import shop.category.CategoryRepository;
import shop.type.Type;

@Service
public class ProductService {
	
	@Autowired
	final ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	List<Product> findProducts(){
		
		return productRepository.findProducts();
	}
	
	/*List<Product> findByQuantityGreaterThan(int value){
		
		return productRepository.findByQuantityGreaterThan(value);
	}*/
	
	public Optional<Product> findProduct(long id) {
		
		return productRepository.findProduct(id);
	}

	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	public List<Product> findProductsByType(String typeName){
		return productRepository.findProductsByType(typeName);
	}
	
	public List<Product> findProductsByCategoryAndType(String typeName, String categoryName){
		return productRepository.findProductsByCategoryAndType(typeName, categoryName);
	}
	
	
	public void delete(long id) {
		
		productRepository.deleteById(id);
	}
}
