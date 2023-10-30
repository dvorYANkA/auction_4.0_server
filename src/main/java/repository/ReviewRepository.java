package repository;

import java.util.List;
import models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByLastName(String lastName);
    Review findById(long id);
}