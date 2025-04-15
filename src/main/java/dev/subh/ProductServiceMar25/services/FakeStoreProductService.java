package dev.subh.ProductServiceMar25.services;


import dev.subh.ProductServiceMar25.dto.CreateProductRequestDto;
import dev.subh.ProductServiceMar25.dto.FakeStoreProductDto;
import dev.subh.ProductServiceMar25.exceptions.ProductNotFoundException;
import dev.subh.ProductServiceMar25.model.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;//used to call 3rd party API's


    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        //as output is array we store it in array type
        FakeStoreProductDto[] fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products"
                        , FakeStoreProductDto[].class);

        //create a list of type product to store the response
        List<Product> products = new ArrayList<>();

        /* iterate through each element of response and convert then store
         * them in the List created*/

        for (FakeStoreProductDto fakestoreProductDto : fakeStoreProductDto) {
            Product p = fakestoreProductDto.toProduct();
            //converting it to dto product object
            products.add(p);
            //add product objects to the products List
        }
        return products;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        /* need to call the external
         fakestore product api here
         'https://fakestoreapi.com/products/1'
         */
//   FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+ id,
//           FakeStoreProductDto.class);
//        return fakeStoreProductDto.toProduct();

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if (fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatusCode.valueOf(200)) {
            //handle exception
         }

        if (fakeStoreProductDtoResponseEntity.getBody() == null) {
            throw new ProductNotFoundException("Product with id "+ id + " is not present, Invalid ID!");
        }

        //fakeStoreProductDtoResponseEntity.getHeaders();

        return fakeStoreProductDtoResponseEntity.getBody().toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {


        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);



        return fakeStoreProductDto1.toProduct();

        // /products API does not actually create new object,
        // its a dummy API!!
    }

    public Product updateProduct(int id,
                                 String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {

        FakeStoreProductDto fakeStoreProductDtoUpdate = new FakeStoreProductDto();

        fakeStoreProductDtoUpdate.setId(id);
        fakeStoreProductDtoUpdate.setTitle(title);
        fakeStoreProductDtoUpdate.setDescription(description);
        fakeStoreProductDtoUpdate.setPrice(price);
        fakeStoreProductDtoUpdate.setImage(imageUrl);
        fakeStoreProductDtoUpdate.setCategory(category);

        HttpEntity<FakeStoreProductDto> entity = new HttpEntity<>(fakeStoreProductDtoUpdate);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto2 = restTemplate.exchange("https://fakestoreapi.com/products/"+ id,
                HttpMethod.PUT, entity, FakeStoreProductDto.class);

        return fakeStoreProductDto2.getBody().toProduct();
    }
}
