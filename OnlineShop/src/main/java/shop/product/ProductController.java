package shop.product;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

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
	
	@Autowired(required=false)
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
		
		//Category category = categoryService.findByName(categoryName);
		String paths[] = globalAdvice.getPathArray(request);
		
		/*Type type = new Type((long)1,"kobiety","opis",true);
		typeService.saveType(type);
		Type type2 = typeService.findByName(type.getName());
		Category category = new Category((long)1,type2, "kobiety", "opis", true);
		
		categoryService.save(category);
		Category category2 = categoryService.findByName(categoryName);
		Product product= new Product((long)1,category2,"kobisjaszi","kob",10,10,10.0,"Nike-spodnie-dresowe.jpg");
		productService.save(product);*/
		
	
		return productService.findProductsByCategoryAndType(paths[1], paths[2]);
	}
	
	@CrossOrigin
	@GetMapping("/{categoryName}/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {

		return productService.findProduct(id);              
	}
	

	
	/*@GetMapping("/instructors/{name}/courses/{id}")
	public Product getSingleProduct(@PathVariable long id) {
		//we need to swap this, we will return error page - go to shop project
		return productService.findById(id).orElse(null);
	}*/
	
	//update
	@PutMapping("/instructors/{name}/courses/{id}")
	public void saveProduct(@PathVariable long id, @RequestBody Product product) {
		productService.save(product);
	}
	
	@DeleteMapping("/instructors/{name}/courses/{id}")
	public void deleteProduct(@PathVariable long id) {
		
		productService.delete(id);
	}

}
