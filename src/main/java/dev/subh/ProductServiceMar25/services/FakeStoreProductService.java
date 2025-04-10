package dev.subh.ProductServiceMar25.services;


import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.dto.FakeStoreProductDto;
import dev.subh.ProductServiceMar25.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;//used to call 3rd party API's

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(long id) {
        /* need to call the external
         fakestore product api here
         'https://fakestoreapi.com/products/1'
         */
   FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+ id,
           FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestsDto) {
        return null;
    }
}
