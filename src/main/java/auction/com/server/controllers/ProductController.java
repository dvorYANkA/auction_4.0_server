package auction.com.server.controllers;

import auction.com.server.models.Product;
import auction.com.server.models.Review;
import auction.com.server.models.filters.ProductFilter;
import auction.com.server.services.ProductService;
import auction.com.server.services.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//RequiredArgsConstructor //decided to use my own -- just because of intuition
public class ProductController {
    private final ProductService productService;
    private final ReviewService reviewService;
    public ProductController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @GetMapping("/products/{id}")
    public Product getSomeProductById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.list();
    }

    @GetMapping("/products/{id}/reviews")
    public List<Review> getReviewsForProduct(@PathVariable("id") int prdId) {
        return reviewService.getReviewsForProduct(prdId);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestBody ProductFilter productFilter){
        return productService.searchProduct(productFilter);
    }
}
