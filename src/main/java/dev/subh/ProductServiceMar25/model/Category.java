package dev.subh.ProductServiceMar25.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
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
            @JsonIgnore // to fix circular reference in response
    List<Product> products;

}
