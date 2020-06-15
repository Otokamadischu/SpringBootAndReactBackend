package shop.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import shop.category.Category;
import shop.type.Type;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public List<Product> findByQuantityGreaterThan(int value);

	//public List<Product> findAllByType(String type);
	
	//public List<Product> findByTypeAndCategoryId(String type, long id);
	
	//public List<Product> findByType_AndCategory_Name(String type, String name);
	
	@Query("SELECT p from Product p JOIN FETCH p.category c JOIN FETCH c.type t WHERE p.productId = :id")
	public Optional<Product> findProduct(@Param("id") Long id);
	
	//We need to add JOIN FETCH otherwise we gets error(Couldn't convert to JSON) 
	@Query("SELECT p from Product p JOIN FETCH p.category c JOIN FETCH c.type t ")
	public List<Product> findProducts();

	@Query("SELECT p from Product p JOIN FETCH p.category c JOIN FETCH c.type t WHERE t.name = :typeName")
	public List<Product> findProductsByType(@Param("typeName") String typeName);
	
	@Query("SELECT p from Product p JOIN FETCH p.category c JOIN FETCH c.type t WHERE t.name = :typeName AND c.name = :categoryName")
	public List<Product> findProductsByCategoryAndType(@Param("typeName") String typeName, @Param("categoryName") String categoryName);
	

}
