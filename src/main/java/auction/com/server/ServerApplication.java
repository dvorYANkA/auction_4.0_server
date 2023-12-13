package auction.com.server;

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

import java.io.IOException;
import java.io.OutputStream;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@RestController
public class ServerApplication {
	//private static JpaService jpaService = JpaService.getInstance();
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
			TestClassToDelete.translateText();
		}catch(IOException ioException){
			System.out.print(ioException.getMessage());
		}finally {
		//	String test = SpringVersion.getVersion();
		//	jpaService.shutdown();
		}
	}
	@Bean
	// Just method demonstrating how to work with repository/service + mb such bean method example will be helpful in future
	protected CommandLineRunner demo(ProductRepository productRepository,ProductService productService) {
		return (args) -> {
			/*productRepository.save(new Product(0,15, "Bauer", 300,"desc","books"));
			productService.addProduct(Product.builder().id(0).title("First product").price(24).rating(4)
					.categories("electronics, hardware")
					.description("This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
					.build());*/
		};
	}
}