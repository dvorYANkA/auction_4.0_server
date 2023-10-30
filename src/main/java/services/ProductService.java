package services;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository bookRepository;

    public List<Product> list() {
        return bookRepository.findAll();
    }
}