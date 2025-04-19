package dev.subh.ProductServiceMar25.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private int id;

    private Date createdAt;
    private Date lastModifiedAt;
    private boolean isDeleted;

}
