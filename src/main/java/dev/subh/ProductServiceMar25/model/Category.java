package dev.subh.ProductServiceMar25.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel {
    private String title;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    List<Product> products;

}
