package shop.product;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import shop.category.Category;
import shop.category.CategoryService;
import shop.global.GlobalAdvice;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/managment")
public class ManagementController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	GlobalAdvice globalAdvice;

	@GetMapping
	public List<Product> getProductsManagment(){
		
		return productService.findProducts();
	}
	
	@GetMapping("/{type}")
	public List<Product> getProductsManagmentByType(HttpServletRequest request) {
		
		String paths[] = globalAdvice.getPathArray(request);
		
		return productService.findProductsByType(paths[2]);
	}
	
	
	@GetMapping("/{type}/{categoryName}")
	public List<Product> getProductsManagmentByTypeAndCategoryId(HttpServletRequest request) {
		
		String paths[] = globalAdvice.getPathArray(request);
		
		return productService.findProductsByCategoryAndType(paths[2], paths[3]);
	}
	
	@PostMapping("/{type}/{category}")
	public ResponseEntity<Void> createProduct(@PathVariable String category, @RequestBody Product product)
	{

		Category category2 = categoryService.findByName(category);
		product.setCategory(category2);
		productService.save(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getProductId())
		        .toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{type}/{category}")
	public ResponseEntity<Void> updateProduct(@PathVariable String category, @RequestBody Product product)
	{

		Category category2 = categoryService.findByName(category);
		product.setCategory(category2);
		productService.save(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getProductId())
		        .toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{type}/{category}/{id}")
	public void deleteProduct(@PathVariable Long id) {
		
		System.out.println("ddadw");
		productService.delete(id);
	}

}
