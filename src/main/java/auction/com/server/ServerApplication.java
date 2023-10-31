package auction.com.server;

import auction.com.server.models.Product;
import auction.com.server.models.Review;
import auction.com.server.models.filters.ProductFilter;
import auction.com.server.repository.ProductRepository;
import auction.com.server.repository.ReviewRepository;
import auction.com.server.services.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import auction.com.server.services.JpaService;
import auction.com.server.services.ProductService;

import java.util.List;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@RestController
public class ServerApplication {
	private final ProductService productService;
	private final ReviewService reviewService;
	private static JpaService jpaService = JpaService.getInstance();
	public ServerApplication(ProductService productService, ReviewService reviewService) {
		this.productService = productService;
		this.reviewService = reviewService;
	}

	public static void main(String[] args) {
		try{
			SpringApplication.run(ServerApplication.class, args);

		//	EntityManagerFactory entityManagerFactory = jpaService.entityManagerFactory();
		//	EntityManager entityManager = entityManagerFactory.createEntityManager();
		//	EntityTransaction transaction = entityManager.getTransaction();
		//	transaction.begin();
		//	entityManager.merge(new Product("entityManager.merge.attempt", 345));
		//	entityManager.merge(new Review());
		//	transaction.commit();
		//	entityManager.close();//TODO: check if it important in general to use such approach with factory/managers/transactions
		}finally {
		//	String test = SpringVersion.getVersion();
			jpaService.shutdown();
		}
	}

	@Bean
	protected CommandLineRunner demo(ProductRepository productRepository, ReviewRepository reviewRepository,
									 ProductService productService, ReviewService reviewService) {
		return (args) -> {/*
			productRepository.save(new Product(0,15, "Bauer", 300,"desc","books"));
			productService.addProduct(Product.builder().id(0).title("First product").price(24).rating(4)
					.categories("electronics, hardware")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(0).title("First product").price(24).rating(4)
					.categories("electronics, hardware")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(1).title("Second product").price(64).rating(3)
					.categories("books")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(2).title("Third product").price(74).rating(4)
					.categories("electronics")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(3).title("Fourth product").price(84).rating(3)
					.categories("hardware")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(4).title("Fifth product").price(94).rating(5)
					.categories("hardware,electronics")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());
			productService.addProduct(Product.builder().id(5).title("Sixth product").price(54).rating(4)
					.categories("books")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());

			reviewService.addReview(Review.builder().id(0).productId(0).timestamp("2014-05-20T02:17:00+00:00")
					.userName("User 1").rating(5).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
			reviewService.addReview(Review.builder().id(1).productId(0).timestamp("2014-05-20T02:53:00+00:00")
					.userName("User 2").rating(3).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
			reviewService.addReview(Review.builder().id(2).productId(1).timestamp("2015-05-20T02:53:00+00:00")
					.userName("User 3").rating(3).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
			reviewRepository.save(Review.builder().id(3).productId(3).timestamp("2014-05-20T02:17:00+00:00")
					.userName("User 6").rating(5).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
					*/};
	}

	@GetMapping("/products/{id}")
	public Product getSomeProductById(@PathVariable("id") Long id){
		return productService.findById(id);
	}

	@GetMapping("/products")
	public List<Product>  getProducts(){
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