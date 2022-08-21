package Projeto.SpringBoot.APIREST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projeto.SpringBoot.APIREST.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
	
	
}
