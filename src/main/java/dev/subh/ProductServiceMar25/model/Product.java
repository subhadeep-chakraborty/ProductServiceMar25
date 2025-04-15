package dev.subh.ProductServiceMar25.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {


    //getter setter used for Logging
    //Using Lombok here
    //for tracking and auditing purpose
    //for exception handling
    private String title;
    private String description;
    private double price;
    //private Category category;
    private String imageUrl; 


}
