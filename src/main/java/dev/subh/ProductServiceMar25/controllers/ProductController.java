package dev.subh.ProductServiceMar25.controllers;

import java.util.List;
import java.util.ArrayList;

import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.model.Product;
import dev.subh.ProductServiceMar25.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    public ProductService productService;
    /*
    at the end of the day
    api = method in my controller
     */

    //Constructor for Dependency Injection of productService
public ProductController(ProductService productService) {
    this.productService = productService;
}


    @GetMapping("/products")
    public List<Product> getAllProducts() {

    return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
        return productService.createProduct(createProductRequestDto);
    }


}
