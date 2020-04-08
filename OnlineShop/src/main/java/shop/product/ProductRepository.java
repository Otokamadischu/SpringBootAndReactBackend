package shop.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByQuantityGreaterThan(int value);

	public List<Product> findAllByType(String type);
	
	public List<Product> findByTypeAndCategoryId(String type, long id);


}
