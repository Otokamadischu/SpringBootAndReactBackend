package shop.product;

import java.net.MalformedURLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.category.Category;
import shop.category.CategoryService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = {"/kobiety","/mezczyzni","/suplementy"})
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired(required=false)
	CategoryService categoryService;
	
	@GetMapping("/{type}")
	public List<Product> getProductsByType(@PathVariable String type){
		
		return productService.findAllByType(type);
	}
	
	@GetMapping("/{type}/{categoryName}")
	public List<Product> getProductsByTypeAndCategoryId(@PathVariable String type, @PathVariable String categoryName){
		Category category = categoryService.findByName(categoryName);
		return productService.findByTypeAndCategoryId(type, category.getCategoryId());
	}
	
	@GetMapping("/instructors/{name}/courses")
	public List<Product> getProducts() throws MalformedURLException{

		return productService.findAll();
	
	}
	
	@GetMapping("/instructors/{name}/courses/{id}")
	public Product getSingleProduct(@PathVariable long id) {
		//we need to swap this, we will return error page - go to shop project
		return productService.findById(id).orElse(null);
	}
	
	@PutMapping("/instructors/{name}/courses/{id}")
	public void saveProduct(@PathVariable long id, @RequestBody Product product) {
		productService.save(product);
	}
	
	@DeleteMapping("/instructors/{name}/courses/{id}")
	public void deleteProduct(@PathVariable long id) {
		
		productService.delete(id);
	}

}
