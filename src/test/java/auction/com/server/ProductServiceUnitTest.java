package auction.com.server;

import auction.com.server.models.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import auction.com.server.services.ProductService;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceUnitTest {
    @Autowired private ProductService productService;//TODO:

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Product> products = productService.list();
        Assert.assertEquals(products.size(), 3);
    }
}