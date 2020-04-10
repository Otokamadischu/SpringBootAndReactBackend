package shop.product;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

import shop.category.Category;
import shop.category.CategoryService;
import shop.global.GlobalAdvice;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = {"/kobiety","/mezczyzni","/suplementy"})
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired(required=false)
	CategoryService categoryService;
	
	@Autowired
	GlobalAdvice globalAdvice;
	
	@GetMapping
	public List<Product> getProductsByType(HttpServletRequest request){
		//URL url = new URL(request.getRequestURL().toString());
		
		URL url = null;
		try {
			url = new URL(request.getRequestURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String path = url.getPath();
	    String[] paths = path.split("/");

		//String paths[] = globalAdvice.getPathArray(request);
		System.out.println(paths[0] + " "+ paths[1]  + " dad");
		return productService.findAllByType(paths[1]);
	}
	
	@GetMapping("/{categoryName}")
	public List<Product> getProductsByTypeAndCategoryId(@PathVariable String categoryName, HttpServletRequest request){
		Category category = categoryService.findByName(categoryName);
		String paths[] = globalAdvice.getPathArray(request);
		return productService.findByTypeAndCategoryId(paths[1], category.getCategoryId());
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
