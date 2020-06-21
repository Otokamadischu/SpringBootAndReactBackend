package shop.product;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

import ch.qos.logback.classic.Logger;
import shop.category.Category;
import shop.category.CategoryService;
import shop.global.GlobalAdvice;
import shop.type.Type;
import shop.type.TypeService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = {"/kobiety","/mezczyzni","/suplementy"})
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired(required=false)
	TypeService typeService;
	
	@Autowired
	GlobalAdvice globalAdvice;
	
	@GetMapping
	public List<Product> getProductsByType(HttpServletRequest request){
		
		String paths[] = globalAdvice.getPathArray(request);
		
		return productService.findProductsByType(paths[1]);
	}
	
	@GetMapping("/{categoryName}")
	public List<Product> getProductsByTypeAndCategory(@PathVariable String categoryName, HttpServletRequest request){

		String paths[] = globalAdvice.getPathArray(request);
		
		return productService.findProductsByCategoryAndType(paths[1], paths[2]);
	}
	
	@CrossOrigin
	@GetMapping("/{categoryName}/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {

		return productService.findProduct(id);              
	}

	@PostMapping("/{category}")
	public ResponseEntity<Void> createProduct(@PathVariable String category, @RequestBody Product product)
	{

		Category category2 = categoryService.findByName(category);
		product.setCategory(category2);
		productService.save(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getProductId())
		        .toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{category}")
	public ResponseEntity<Void> updateProduct(@PathVariable String category, @RequestBody Product product)
	{

		Category category2 = categoryService.findByName(category);
		product.setCategory(category2);
		productService.save(product);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getProductId())
		        .toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{category}/{id}")
	public void deleteProduct(@PathVariable Long id) {
		
		System.out.println("ddadw");
		productService.delete(id);
	}
}
