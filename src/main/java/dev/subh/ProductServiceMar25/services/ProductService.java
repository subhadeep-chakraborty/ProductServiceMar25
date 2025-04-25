package dev.subh.ProductServiceMar25.services;


import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.exceptions.ProductNotFoundException;
import dev.subh.ProductServiceMar25.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() ;

     Product getSingleProduct(int id) throws ProductNotFoundException;

    Product createProduct (String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category) ;

    Product updateProduct(int id,
                          String title,
                          String description,
                          double price,
                          String imageUrl,
                          String category) ;
}
