package dev.subh.ProductServiceMar25.controllers;

import java.util.List;
import java.util.ArrayList;

import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.dto.ErrorDto;
import dev.subh.ProductServiceMar25.dto.UpdateProductRequestDto;
import dev.subh.ProductServiceMar25.exceptions.ProductNotFoundException;
import dev.subh.ProductServiceMar25.model.Product;
import dev.subh.ProductServiceMar25.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product p = productService.getSingleProduct(id);
        ResponseEntity<Product> response;
        if(p == null) {
             response = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }else{
             response = new ResponseEntity<>(p, HttpStatus.OK);
        }

        return response;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
        return productService.createProduct(
                createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory()
        );
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto, @PathVariable("id") int id)
    {
        updateProductRequestDto.setId(id);

        return productService.updateProduct(

                updateProductRequestDto.getId(),
                updateProductRequestDto.getTitle(),
                updateProductRequestDto.getDescription(),
                updateProductRequestDto.getPrice(),
                updateProductRequestDto.getImage(),
                updateProductRequestDto.getCategory()
        );
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//    ErrorDto errorDto = new ErrorDto();
//    errorDto.setMessage(productNotFoundException.getMessage());
//
//    ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    return response;
//}


}
