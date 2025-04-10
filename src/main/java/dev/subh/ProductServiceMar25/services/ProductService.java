package dev.subh.ProductServiceMar25.services;


import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() ;

     Product getSingleProduct(long id);

    Product createProduct(CreateProductRequestDto createProductRequestsDto) ;
}
