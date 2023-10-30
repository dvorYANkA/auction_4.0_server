package repository;

import java.util.List;

import models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByLastName(String lastName);
    Product findById(long id);
}