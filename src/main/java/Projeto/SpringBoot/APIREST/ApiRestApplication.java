package Projeto.SpringBoot.APIREST;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Projeto.SpringBoot.APIREST.entities.Category;
import Projeto.SpringBoot.APIREST.entities.Products;
import Projeto.SpringBoot.APIREST.repositories.CategoryRepository;
import Projeto.SpringBoot.APIREST.repositories.ProductRepository;

@SpringBootApplication
public class ApiRestApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productsRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");

		Products p1 = new Products(null, "TV", 2200.00, cat1);
		Products p2 = new Products(null, "Domain Driven Design", 120.00, cat2);
		Products p3 = new Products(null, "PS5", 2800.00, cat1);
		Products p4 = new Products(null, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
		productsRepository.save(p1);
		productsRepository.save(p2);
		productsRepository.save(p3);
		productsRepository.save(p4);
	}

}
