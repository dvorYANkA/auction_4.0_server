package auction.com.server;

import model.Product;
import model.Review;
import model.filter.ProductFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@RestController
@Controller
public class ServerApplication {
	List<Product> productListInsteadDB = new ArrayList<>();
	List<Review> reviewListInsteadDB = new ArrayList<>();

	ServerApplication(){
		productListInsteadDB.add(Product.builder().id(0).title("First product").price(24).rating(4)
				.categories("electronics, hardware")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());
		productListInsteadDB.add(Product.builder().id(1).title("Second product").price(64).rating(3)
				.categories("books")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());
		productListInsteadDB.add(Product.builder().id(2).title("Third product").price(74).rating(4)
				.categories("electronics")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());
		productListInsteadDB.add(Product.builder().id(3).title("Fourth product").price(84).rating(3)
				.categories("hardware")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());
		productListInsteadDB.add(Product.builder().id(4).title("Fifth product").price(94).rating(5)
				.categories("hardware,electronics")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());
		productListInsteadDB.add(Product.builder().id(5).title("Sixth product").price(54).rating(4)
				.categories("books")
				.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
				.build());

		reviewListInsteadDB.add(Review.builder().id(0).productId(0).timestamp("2014-05-20T02:17:00+00:00")
				.userName("User 1").rating(5).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
		reviewListInsteadDB.add(Review.builder().id(1).productId(0).timestamp("2014-05-20T02:53:00+00:00")
				.userName("User 2").rating(3).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
		reviewListInsteadDB.add(Review.builder().id(2).productId(1).timestamp("2015-05-20T02:53:00+00:00")
				.userName("User 3").rating(3).comment("Aenean vestibulum velit id placerat posuere. Praesent...").build());
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@GetMapping("/products/{id}")
	public Product getSomeProductById(@PathVariable("id") Integer id){
		return productListInsteadDB.get(id);
	}

	@GetMapping("/products")
	public List<Product>  getProducts(){
		return productListInsteadDB;
	}

	@GetMapping("/products/{id}/reviews")
	public List<Review> getReviewsForProduct(@PathVariable("id") int id) {
		List<Review> returnList = new ArrayList<>();
		for (Review review: reviewListInsteadDB){
			if(review.getProductId() == id)
				returnList.add(review);
		}
		return returnList;
	}

	@GetMapping("/products/search")
	public List<Product> searchProducts(@RequestBody ProductFilter productFilter){
		List<Product> test = new ArrayList<>();
		for(Product product: productListInsteadDB){
			if(product.getPrice() == productFilter.getPrice() &&
					product.getTitle().toLowerCase().equals(productFilter.getTitle().toLowerCase()) &&
					categoryFound(productFilter.getCategory(),product.getCategories())
				)
				test.add(product);
		}
		return test;
	}

	private boolean categoryFound(String filterCategory, String productCategories) {
		boolean categoryFound = false;
		String[] categoriesArray = productCategories.split(",");
		for(int i = 0 ; i < categoriesArray.length; i++){
			categoriesArray[i] = categoriesArray[i].trim();
		}

		for(String category: categoriesArray){
			if (filterCategory.toLowerCase().equals(category.toLowerCase())){
				categoryFound = true;
				break;
			}
		}
		return categoryFound;
	}
}
