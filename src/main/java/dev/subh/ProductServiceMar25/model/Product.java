package dev.subh.ProductServiceMar25.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {


    //getter setter used for Logging
    //Using Lombok here
    //for tracking and auditing purpose
    //for exception handling
    private int id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String imageUrl; 


}
