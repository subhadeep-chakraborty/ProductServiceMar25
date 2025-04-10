package dev.subh.ProductServiceMar25;

import dev.subh.ProductServiceMar25.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceMar25Application {




	public static void main(String[] args) {
		SpringApplication.run(ProductServiceMar25Application.class, args);
		Product p1 = new Product();
		p1.getId();
	}

}
