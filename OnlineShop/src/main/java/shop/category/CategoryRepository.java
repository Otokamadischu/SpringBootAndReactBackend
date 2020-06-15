package shop.category;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import shop.product.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);

}
