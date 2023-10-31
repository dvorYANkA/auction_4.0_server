package auction.com.server.services;

import auction.com.server.models.Product;
import auction.com.server.models.Review;
import auction.com.server.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public List<Review> list() {return reviewRepository.findAll();}

    public Review findById(long prdId){return reviewRepository.findById(prdId);}
    public void addReview(Review review){reviewRepository.save(review);}

    public List<Review> getReviewsForProduct(int prdId){
        List<Review> returnList = new ArrayList<>();
        for (Review review: reviewRepository.findAll()){
            if(review.getProductId() == prdId)
                returnList.add(review);
        }
        return returnList;
    }
}
