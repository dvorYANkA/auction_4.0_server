package auction.com.server.services;

import auction.com.server.models.filters.ProductFilter;
import auction.com.server.repository.ProductRepository;
import auction.com.server.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(long prdId){
        return productRepository.findById(prdId);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public List<Product> searchProduct(ProductFilter productFilter){
        List<Product> test = new ArrayList<>();
        for(Product product: productRepository.findAll()){
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