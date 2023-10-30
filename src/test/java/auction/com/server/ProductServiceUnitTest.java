package auction.com.server;

import models.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import services.ProductService;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceUnitTest {
    @Autowired private ProductService productService = new ProductService();//TODO:

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Product> products = productService.list();
        Assert.assertEquals(products.size(), 3);
    }
}