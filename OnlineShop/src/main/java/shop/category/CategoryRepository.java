package shop.category;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import shop.product.Product;
import shop.type.Type;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);

	@Query("SELECT c from Category c JOIN FETCH c.type t WHERE t.name = :typeName")
	public List<Category> findCategoriesByType(@Param("typeName") String type);


}
