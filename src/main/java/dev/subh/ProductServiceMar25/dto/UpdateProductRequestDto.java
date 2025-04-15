package dev.subh.ProductServiceMar25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequestDto {

        private int id;
        private String title;
        private String description;
        private double price;
        private String image;
        private String category;
}
