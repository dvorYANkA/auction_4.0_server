package auction.com.server.controllers;

import auction.com.server.models.Product;
import auction.com.server.models.Review;
import auction.com.server.models.filters.ProductFilter;
import auction.com.server.services.ProductService;
import auction.com.server.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//RequiredArgsConstructor //decided to use my own -- just because of intuition
public class ProductController {
    private final ProductService productService;
    private final ReviewService reviewService;
    public ProductController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Product getSomeProductById(@PathVariable("id") Long id){return productService.findById(id);}

    @GetMapping()
    public List<Product> getProducts(){return productService.list();}

    @GetMapping("/{id}/reviews")
    public List<Review> getReviewsForProduct(@PathVariable("id") int prdId) {return reviewService.getReviewsForProduct(prdId);}

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestBody ProductFilter productFilter){
        return productService.searchProduct(productFilter);
    }

    @PutMapping(value = "/update/{id}")
    public Product update(@PathVariable("id") long id,
                          @RequestBody Product product){
        return productService.update(product, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id){
        productService.delete(id);
    }}


//TODO разобраться с типами данных (long/Long и т.д.)