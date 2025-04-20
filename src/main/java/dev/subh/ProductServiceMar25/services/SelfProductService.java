package dev.subh.ProductServiceMar25.services;

import dev.subh.ProductServiceMar25.exceptions.ProductNotFoundException;
import dev.subh.ProductServiceMar25.model.Category;
import dev.subh.ProductServiceMar25.model.Product;
import dev.subh.ProductServiceMar25.repositories.CategoryRepository;
import dev.subh.ProductServiceMar25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SelfProductService implements ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository,
                              ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {

        Product product1 = new Product();
         product1.setTitle(title);
         product1.setDescription(description);
         product1.setPrice(price);
         product1.setImageUrl(imageUrl);

         Category categoryFromDB= categoryRepository.findByTitle(category);

         if(categoryFromDB == null || categoryFromDB.getTitle() == null){
             Category newCategory = new Category();
             newCategory.setTitle(category);

             categoryFromDB = newCategory;
         }

         product1.setCategory(categoryFromDB);
         Product createdProduct = productRepository.save(product1);


        return createdProduct;
    }

    @Override
    public Product updateProduct(int id, String title, String description, double price, String imageUrl, String category) {
        return null;
    }
}
