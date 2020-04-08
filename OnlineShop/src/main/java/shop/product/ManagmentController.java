package shop.product;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.category.Category;
import shop.category.CategoryService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/managment")
public class ManagmentController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public List<Product> getProductsManagment(){
		return productService.findAll();
	}
	
	@GetMapping("/{type}")
	public List<Product> getProductsManagmentByType(@PathVariable String type) {
		return productService.findAllByType(type);
	}
	
	
	@GetMapping("/{type}/{categoryName}")
	public List<Product> getProductsManagmentByTypeAndCategoryId(@PathVariable String type, @PathVariable String categoryName) {
		Category category = categoryService.findByName(categoryName);
		return productService.findByTypeAndCategoryId(type, category.getCategoryId());
	}

}
