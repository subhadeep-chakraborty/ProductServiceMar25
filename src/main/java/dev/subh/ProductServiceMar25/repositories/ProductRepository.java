package dev.subh.ProductServiceMar25.repositories;

import dev.subh.ProductServiceMar25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);
}
