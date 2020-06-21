package shop.product;

import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.category.Category;
import shop.category.CategoryService;
import shop.global.GlobalAdvice;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/managment")
public class ManagmentController {
	
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

}
