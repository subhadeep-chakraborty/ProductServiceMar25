package dev.subh.ProductServiceMar25.dto;


import dev.subh.ProductServiceMar25.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreProductDto {
    private int id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setPrice( price);
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setId(id);
        return product;
    }

}
