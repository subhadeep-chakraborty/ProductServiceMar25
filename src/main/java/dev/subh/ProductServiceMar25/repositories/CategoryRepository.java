package dev.subh.ProductServiceMar25.repositories;

import dev.subh.ProductServiceMar25.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByTitle(String title); //JPA Method


    Optional<Category> findById(int id); //If category not available

    /*
    Internally JPA will write a query
    Select * from Category
    where title like 'title'
    JPA will convert the row to category object and return
     */

}
