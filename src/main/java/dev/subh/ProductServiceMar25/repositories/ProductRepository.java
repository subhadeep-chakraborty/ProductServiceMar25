package dev.subh.ProductServiceMar25.repositories;

import dev.subh.ProductServiceMar25.model.Category;
import dev.subh.ProductServiceMar25.model.Product;
import dev.subh.ProductServiceMar25.projections.ProductProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Integer integer);

    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Title(String categoryTitle);

    @Query("select p.title as title, p.id as id from Product p where p.category.id = :categoryId") //Hibernatate Query Language
    List<ProductProjections> getTitlesAndIdOfAllProductsWithGivenCategoryId(@Param("categoryName") Integer categoryId);
}
