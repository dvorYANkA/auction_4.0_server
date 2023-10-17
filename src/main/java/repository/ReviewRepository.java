package repository;

import java.util.List;
import model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByLastName(String lastName);
    Review findById(long id);
}