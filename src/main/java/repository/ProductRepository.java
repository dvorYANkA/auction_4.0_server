package repository;

import java.util.List;

import model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findByLastName(String lastName);
    Product findById(long id);
}