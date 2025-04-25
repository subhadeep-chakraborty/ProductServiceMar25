package dev.subh.ProductServiceMar25;

import dev.subh.ProductServiceMar25.model.Product;
import dev.subh.ProductServiceMar25.projections.ProductProjections;
import dev.subh.ProductServiceMar25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootTest
class ProductServiceMar25ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testingQueries(){
		List< Product> products = productRepository.findAllByCategory_Title("electronics");
		System.out.println(products);
	}
	@Test
			void testingQueries2(){

		List<ProductProjections> productProjections =  productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryId(2);
		productProjections.forEach(p -> System.out.println(p.getTitle() + " - " + p.getId()));

	}

}
