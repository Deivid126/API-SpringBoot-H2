package Projeto.SpringBoot.APIREST.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projeto.SpringBoot.APIREST.entities.Products;
import Projeto.SpringBoot.APIREST.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Products>> findAll() {
		List<Products> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id) {
		Products cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}